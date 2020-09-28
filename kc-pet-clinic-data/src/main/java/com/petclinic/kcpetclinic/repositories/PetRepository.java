package com.petclinic.kcpetclinic.repositories;

import com.petclinic.kcpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
