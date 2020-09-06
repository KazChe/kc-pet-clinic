package com.petclinic.kcpetclinic.bootstrap;

import com.petclinic.kcpetclinic.model.Owner;
import com.petclinic.kcpetclinic.model.Vet;
import com.petclinic.kcpetclinic.services.OwnerService;
import com.petclinic.kcpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    // constructor injecion
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setFirstName("Kimia");
        owner1.setLastName("Chehresa");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Kaz");
        owner2.setLastName("Chehresa");
        ownerService.save(owner2);

        System.out.println("....Owner data created...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Gooz");
        vet1.setLastName("Goozian");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Chosu");
        vet2.setLastName("Chosian");
        vetService.save(vet2);

        System.out.println("....Vet data created...");

    }
}
