package com.petclinic.kcpetclinic.repositories;

import com.petclinic.kcpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
