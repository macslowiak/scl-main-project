package com.spring.springcourselearningpetclinic.services;

import com.spring.springcourselearningpetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
