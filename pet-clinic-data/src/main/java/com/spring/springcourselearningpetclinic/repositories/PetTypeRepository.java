package com.spring.springcourselearningpetclinic.repositories;

import com.spring.springcourselearningpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
