package com.spring.springcourselearningpetclinic.repositories;

import com.spring.springcourselearningpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);
}
