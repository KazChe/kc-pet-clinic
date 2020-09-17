package com.petclinic.kcpetclinic.services.map;

import com.petclinic.kcpetclinic.model.Owner;
import com.petclinic.kcpetclinic.model.Pet;
import com.petclinic.kcpetclinic.services.OwnerService;
import com.petclinic.kcpetclinic.services.PetService;
import com.petclinic.kcpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMap
        extends AbstractmapService<Owner, Long>
        implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    public Set<Owner> findAll() {
        return super.findAll();
    }

    public Owner findById(Long id) {
        return super.findById(id);
    }

    public Owner save(Owner object) {
        if(object != null) {
            if(object.getPets() != null) {
                object.getPets().forEach(pet ->{
                    if (pet.getPetType() != null) {
                        if(pet.getPetType().getId() == null) {
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }

                    } else {
                        throw new RuntimeException("Pet Type is required.");
                    }

                    if(pet.getId() == null) {
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());

                    }

                });
            }
            return super.save(object);
        } else {
            return null;
        }

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
