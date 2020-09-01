class NeoConnector:
    def __init__(self, uri, uid, pwd, max_ttl_sec=120):
        self._dr = None
        self._created = None
        self._uri = uri
        self._uid = uid
        self._pwd = pwd
        self._ttl_sec = max_ttl_sec


    def _resolve(self, address):
        host, port = address

        for h in host.split(','):
            yield h, port

    def reset(self):
        if self._dr:
            self._dr.close()
            self._dr = None
            self._created = None

    def driver(self):
        if self._dr:
            return self._dr

        self._dr = GraphDatabase.driver(self._uri, auth=basic_auth(self._uid,self._pwd), resolver=self._resolve)
        self._created = int(datetime.now().timestamp())
        return self._dr

    def check_ttl(self):
        if self._created:
            now = int(datetime.now().timestamp())
            if now - self._created > self._ttl_sec:
                self.reset()

_conn_write = NeoConnector(_uri,_uid,_pwd, _max_ttl_sec)

def upsert_nodes(nodes, relations):
    """
    Write nodes and relations to graph database.
    :param nodes: dictionary of nodes by labels; each entry in the dictionary needs to be a collection of
    dictionaries. Each dictionary in the collection will contain key value pairs of property names and
    values.
    :param relations: dictionary of relations by relation type. Each entry in the dictionary needs to be a
    collection of RelationLine class json serialized.
    """
    def upsert_nodes_call(tx):
        tx.run("call com.pricing.intake.CreateNodesAndRelations", {'nodesByLabels': nodes, 'relationsByTypes': relations})

    try:
        with _conn_write.driver().session() as session:
            session.write_transaction(lambda tx: upsert_nodes_call(tx))
            neo_bookmark = session.last_bookmark()

        return neo_bookmark
    except:
        _conn_write.reset()
        raise
    finally:
        _conn_write.check_ttl()