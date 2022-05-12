package com.spring.springcourselearningpetclinic.services;

import com.spring.springcourselearningpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);


}
