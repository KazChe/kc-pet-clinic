package com.petclinic.kcpetclinic.services;

import com.petclinic.kcpetclinic.model.Owner;
import com.petclinic.kcpetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Owner owner);

    Set<Pet> findAll();
}
