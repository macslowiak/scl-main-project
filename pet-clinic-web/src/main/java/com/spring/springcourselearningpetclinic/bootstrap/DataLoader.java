package com.spring.springcourselearningpetclinic.bootstrap;

import com.spring.springcourselearningpetclinic.model.Owner;
import com.spring.springcourselearningpetclinic.model.Pet;
import com.spring.springcourselearningpetclinic.model.PetType;
import com.spring.springcourselearningpetclinic.model.Vet;
import com.spring.springcourselearningpetclinic.services.OwnerService;
import com.spring.springcourselearningpetclinic.services.PetTypeService;
import com.spring.springcourselearningpetclinic.services.VetService;
import org.apache.tomcat.jni.Local;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Set;

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
        owner1.setAddress("Jana Pawła II / 13");
        owner1.setCity("Warszawa");
        owner1.setTelephone("987384678");

        Pet maciejPet = new Pet();
        maciejPet.setName("Duduś");
        maciejPet.setPetType(savedDogPetType);
        maciejPet.setOwner(owner1);
        maciejPet.setBrithDate(LocalDate.of(2015,3,10));
        owner1.getPets().add(maciejPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Mateusz");
        owner2.setLastName("Słowiak");
        owner1.setAddress("Jana Pawła II / 11");
        owner1.setCity("Kraków");
        owner1.setTelephone("432543623");

        Pet mateuszPet = new Pet();
        mateuszPet.setName("Hania");
        mateuszPet.setPetType(savedCatPetType);
        mateuszPet.setOwner(owner2);
        mateuszPet.setBrithDate(LocalDate.of(2016,2,1));
        owner2.getPets().add(mateuszPet);

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
