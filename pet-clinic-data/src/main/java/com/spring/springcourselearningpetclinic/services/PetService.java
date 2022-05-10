package com.spring.springcourselearningpetclinic.services;

import com.spring.springcourselearningpetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
