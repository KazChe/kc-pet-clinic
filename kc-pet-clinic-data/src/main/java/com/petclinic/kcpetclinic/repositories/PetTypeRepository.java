package com.petclinic.kcpetclinic.repositories;

import com.petclinic.kcpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
