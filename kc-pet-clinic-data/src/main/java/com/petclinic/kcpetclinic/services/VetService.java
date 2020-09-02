package com.petclinic.kcpetclinic.services;

import com.petclinic.kcpetclinic.model.Pet;
import com.petclinic.kcpetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Vet save(Vet owner);

    Set <Pet> findAll();
}
