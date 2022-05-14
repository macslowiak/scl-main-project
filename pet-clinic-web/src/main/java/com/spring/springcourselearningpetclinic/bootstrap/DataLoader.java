package com.spring.springcourselearningpetclinic.bootstrap;

import com.spring.springcourselearningpetclinic.model.Owner;
import com.spring.springcourselearningpetclinic.model.Pet;
import com.spring.springcourselearningpetclinic.model.PetType;
import com.spring.springcourselearningpetclinic.model.Speciality;
import com.spring.springcourselearningpetclinic.model.Vet;
import com.spring.springcourselearningpetclinic.model.Visit;
import com.spring.springcourselearningpetclinic.services.OwnerService;
import com.spring.springcourselearningpetclinic.services.PetTypeService;
import com.spring.springcourselearningpetclinic.services.SpecialtyService;
import com.spring.springcourselearningpetclinic.services.VetService;
import com.spring.springcourselearningpetclinic.services.VisitService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
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
        dog.setName("Labi");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Mruczek");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialtyService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialtyService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("dentistry");
        Speciality savedDentistry = specialtyService.save(dentistry);


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
        maciejPet.setBrithDate(LocalDate.of(2015, 3, 10));
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
        mateuszPet.setBrithDate(LocalDate.of(2016, 2, 1));
        owner2.getPets().add(mateuszPet);

        ownerService.save(owner2);

        Visit visit1 = new Visit();
        visit1.setDate(LocalDate.of(2009, 3, 12));
        visit1.setDescription("Tooth cleaning");
        visit1.setPet(maciejPet);

        visitService.save(visit1);

        System.out.println("--- Owners loaded ---");

        Vet vet1 = new Vet();
        vet1.setFirstName("Marcin");
        vet1.setLastName("Smakosz");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Wojtek");
        vet2.setLastName("Radny");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("--- Vets loaded ---");
    }
}
