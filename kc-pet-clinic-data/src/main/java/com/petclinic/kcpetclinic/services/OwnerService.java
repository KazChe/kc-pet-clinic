package com.petclinic.kcpetclinic.services;

import com.petclinic.kcpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
