package com.petclinic.kcpetclinic.services.map;

import com.petclinic.kcpetclinic.model.Pet;
import com.petclinic.kcpetclinic.services.CrudService;

import java.util.Set;

public class PetServiceMap
        extends AbstractmapService<Pet, Long>
        implements CrudService<Pet, Long> {

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object.getId(), object);
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }
}