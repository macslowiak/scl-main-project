package com.spring.springcourselearningpetclinic.repositories;

import com.spring.springcourselearningpetclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

import javax.sql.rowset.CachedRowSet;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
