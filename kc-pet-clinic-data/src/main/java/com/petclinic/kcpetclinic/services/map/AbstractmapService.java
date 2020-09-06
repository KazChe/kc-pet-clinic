package com.petclinic.kcpetclinic.services.map;

import com.petclinic.kcpetclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractmapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = (Map<Long, T>) new HashMap<ID, T>();

    Set<T> findAll() {
        return new HashSet(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    T save(T object) {
        if(object != null) {
            if(object.getId() == null) {
                object.setId(getNextId());
            }
            map.put(object.getId(), object);
        } else {
            throw new RuntimeException(("object can not be null"));
        }
        return object;
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(final T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    private Long getNextId() {
        Long nextId = null;

        try {
            nextId = Collections.max(map.keySet()) + 1;
        } catch (NoSuchElementException e) {
            nextId = 1L;
        }
        return nextId;
    }
}
