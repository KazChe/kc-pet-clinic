package com.petclinic.kcpetclinic.repositories;

import com.petclinic.kcpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
