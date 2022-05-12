package com.spring.springcourselearningpetclinic.bootstrap;

import com.spring.springcourselearningpetclinic.model.Owner;
import com.spring.springcourselearningpetclinic.model.Vet;
import com.spring.springcourselearningpetclinic.services.OwnerService;
import com.spring.springcourselearningpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }


    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setFirstName("Maciej");
        owner1.setLastName("Słowiak");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Mateusz");
        owner2.setLastName("Słowiak");

        ownerService.save(owner2);

        System.out.println("--- Owners loaded ---");

        Vet vet1 = new Vet();
        vet1.setFirstName("Marcin");
        vet1.setLastName("Smakosz");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Wojtek");
        vet2.setLastName("Radny");

        vetService.save(vet2);

        System.out.println("--- Vets loaded ---");

    }
}
