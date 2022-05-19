package com.spring.springcourselearningpetclinic.repositories;

import com.spring.springcourselearningpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(@Param("lastname") String lastName);
}
