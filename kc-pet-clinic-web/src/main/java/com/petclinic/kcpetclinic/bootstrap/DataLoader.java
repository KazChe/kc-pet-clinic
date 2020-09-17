package com.petclinic.kcpetclinic.bootstrap;

import com.petclinic.kcpetclinic.model.*;
import com.petclinic.kcpetclinic.services.OwnerService;
import com.petclinic.kcpetclinic.services.PetTypeService;
import com.petclinic.kcpetclinic.services.SpecialtiesService;
import com.petclinic.kcpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    // constructor injecion
    private final OwnerService ownerService;
    private final VetService vetService;
    private  final PetTypeService petTypeService;
    private final SpecialtiesService specialtiesService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtiesService specialtiesService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtiesService = specialtiesService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {

        PetType dog = new PetType();
        dog.setName("Topol");
        PetType saveDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Calvin");
        PetType saveCatType = petTypeService.save(cat);

        System.out.println("....PeTypes Created.");

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtiesService.save(dentistry);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology= specialtiesService.save(radiology);

        Specialty anesthesia = new Specialty();
        anesthesia.setDescription("Anesthesia");
        Specialty savedAnesthesia = specialtiesService.save(anesthesia);

        Owner owner1 = new Owner();
        owner1.setFirstName("Kimia");
        owner1.setLastName("Chehresa");
        owner1.setAddress("123 Main Street");
        owner1.setCity("Overland Park");
        owner1.setTelephone("3145555555");

        Pet kimisPet = new Pet();
        kimisPet.setPetType(saveDogType);
        kimisPet.setOwner(owner1);
        kimisPet.setName("Cunter");
        kimisPet.setBirthDate(LocalDate.now());
        owner1.getPets().add(kimisPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Kaz");
        owner2.setLastName("Chehresa");
        owner2.setAddress("676 Elem Street");
        owner2.setCity("Amsterdam");
        owner2.setTelephone("4445567654");

        Pet kazsPet = new Pet();
        kazsPet.setPetType(saveCatType);
        kazsPet.setOwner(owner2);
        kazsPet.setName("Fiona");
        kazsPet.setBirthDate(LocalDate.now());
        owner2.getPets().add(kazsPet);

        ownerService.save(owner2);

        System.out.println("....Owner data created...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Gooz");
        vet1.setLastName("Goozian");
        vet1.getSpecialties().add(radiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Chosu");
        vet2.setLastName("Chosian");
        vet2.getSpecialties().add(dentistry);
        vetService.save(vet2);

        System.out.println("....Vet data created...");
    }
}
