package com.spring.springcourselearningpetclinic.bootstrap;

import com.spring.springcourselearningpetclinic.model.Owner;
import com.spring.springcourselearningpetclinic.model.PetType;
import com.spring.springcourselearningpetclinic.model.Vet;
import com.spring.springcourselearningpetclinic.services.OwnerService;
import com.spring.springcourselearningpetclinic.services.PetTypeService;
import com.spring.springcourselearningpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }


    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Labi");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Mruczek");
        PetType savedCatPetType = petTypeService.save(cat);


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
