package com.spring.springcourselearningpetclinic.repositories;

import com.spring.springcourselearningpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
