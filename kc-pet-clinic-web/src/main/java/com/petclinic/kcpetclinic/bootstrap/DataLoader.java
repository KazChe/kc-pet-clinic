package com.petclinic.kcpetclinic.bootstrap;

import com.petclinic.kcpetclinic.services.OwnerService;
import com.petclinic.kcpetclinic.services.VetService;
import com.petclinic.kcpetclinic.services.map.OwnerServiceMap;
import com.petclinic.kcpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    // get handle on services
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService   = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
