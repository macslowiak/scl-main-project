package com.spring.springcourselearningpetclinic.services.map;


import com.spring.springcourselearningpetclinic.model.Owner;
import com.spring.springcourselearningpetclinic.services.PetService;
import com.spring.springcourselearningpetclinic.services.PetTypeService;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Set;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;

    @Mock
    PetService petService;

    @Mock
    PetTypeService petTypeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        ownerServiceMap = new OwnerServiceMap(petTypeService, petService);

        for (long id = 1; id <5; id++) {
            ownerServiceMap.save(Owner.builder().id(id).lastName("person" + id).build());
        }

    }

    @Test
    void findAll() {
        //when
        Set<Owner> ownerSet = ownerServiceMap.findAll();
        //then
        assertEquals(4, ownerSet.size());
    }

    @Test
    void deleteById() {
        //given
        Long expectedOwnerId = 3L;

        //when
        ownerServiceMap.deleteById(expectedOwnerId);
        //then
        assertNull(ownerServiceMap.findById(expectedOwnerId));
    }

    @Test
    void delete() {
        //given
        Owner owner = Owner.builder().id(5L).build();
        //when
        ownerServiceMap.delete(owner);
        //then
        assertNull(ownerServiceMap.findById(owner.getId()));
    }

    @Test
    void save() {
        //given
        long amountOfOwners = 5L;
        Owner owner = Owner.builder().id(5L).build();
        //when
        ownerServiceMap.save(owner);
        //then
        assertEquals(amountOfOwners,ownerServiceMap.findAll().size());

    }

    @Test
    void findById() {
        //given
        Long expectedOwnerId = 3L;
        //when
        Owner outputOwner = ownerServiceMap.findById(expectedOwnerId);
        //then
        assertEquals(expectedOwnerId,outputOwner.getId());
    }

    @Test
    void findByLastName() {
        //given

        String expectedOwnerName = "person4";
        //when
        Owner outputOwner = ownerServiceMap.findByLastName(expectedOwnerName);
        //then
        assertEquals(expectedOwnerName,outputOwner.getLastName());
    }
}