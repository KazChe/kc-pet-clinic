package com.petclinic.kcpetclinic.services.map;

import com.petclinic.kcpetclinic.model.Owner;
import com.petclinic.kcpetclinic.services.OwnerService;

import java.util.Set;

public class OwnerServiceMap
        extends AbstractmapService<Owner, Long>
        implements OwnerService<Owner, Long> {

    public Set<Owner> findAll() {
        return super.findAll();
    }

    public Owner findById(Long id) {
        return super.findById(id);
    }

    public Owner save(Owner object) {
        return super.save(object.getId(), object);
    }

    public void delete(Owner object) {
        super.delete(object);
    }

    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override //TODO - implement laytuh
    public Owner findByLastName(String lastName) {
        return null;
    }
}
