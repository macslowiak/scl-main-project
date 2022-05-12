package com.spring.springcourselearningpetclinic.bootstrap;

import com.spring.springcourselearningpetclinic.model.Owner;
import com.spring.springcourselearningpetclinic.model.Vet;
import com.spring.springcourselearningpetclinic.services.OwnerService;
import com.spring.springcourselearningpetclinic.services.VetService;
import com.spring.springcourselearningpetclinic.services.map.OwnerServiceMap;
import com.spring.springcourselearningpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(){
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Maciej");
        owner1.setLastName("Słowiak");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Mateusz");
        owner2.setLastName("Słowiak");

        ownerService.save(owner2);

        System.out.println("--- Owners loaded ---");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Marcin");
        vet1.setFirstName("Smakosz");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Wojtek");
        vet2.setFirstName("Radny");

        vetService.save(vet2);

        System.out.println("--- Vets loaded ---");

    }
}