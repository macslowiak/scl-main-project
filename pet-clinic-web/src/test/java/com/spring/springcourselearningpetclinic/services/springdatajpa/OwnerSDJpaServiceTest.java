package com.spring.springcourselearningpetclinic.services.springdatajpa;


import com.spring.springcourselearningpetclinic.model.Owner;
import com.spring.springcourselearningpetclinic.repositories.OwnerRepository;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


class OwnerSDJpaServiceTest {

    public static final String LAST_NAME = "Smith";
    Owner returnOwner;

    OwnerSDJpaService ownerSDJpaService;

    @Mock
    OwnerRepository ownerRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        ownerSDJpaService = new OwnerSDJpaService(ownerRepository);
        returnOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
    }

    @Test
    void findAll() {
        Set<Owner> returnOwnersSet = new HashSet<>();
        returnOwnersSet.add(Owner.builder().id(1L).build());
        returnOwnersSet.add(Owner.builder().id(2L).build());
        when(ownerRepository.findAll()).thenReturn(returnOwnersSet);
        //when
        Set<Owner> ownerSet = ownerSDJpaService.findAll();
        //then
        assertEquals(2, ownerSet.size());
    }

    @Test
    void findById() {
        //given
        Long expectedOwnerId = 1L;
        when(ownerRepository.findById(expectedOwnerId)).thenReturn(
                Optional.ofNullable(returnOwner));
        //when
        Owner outputOwner = ownerSDJpaService.findById(expectedOwnerId);
        //then
        assertEquals(expectedOwnerId,outputOwner.getId());
    }

    @Test
    void save() {
        //given
        Owner owner = Owner.builder().id(5L).build();
        when(ownerRepository.save(owner)).thenReturn(owner);
        //when
        Owner outputOwner = ownerSDJpaService.save(owner);
        //then
        assertEquals(owner,outputOwner);
    }

    @Test
    void delete() {
        //given when
        ownerSDJpaService.delete(returnOwner);
        //then
        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        //given when
        ownerSDJpaService.deleteById(1L);
        //then
        verify(ownerRepository).deleteById(anyLong());
    }
    @Test
    void findByLastName() {

    //given
        Owner returnOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
        when(ownerSDJpaService.findByLastName(any())).thenReturn(returnOwner);

        //when
        Owner owner = ownerSDJpaService.findByLastName(LAST_NAME);

        //then
        assertEquals(LAST_NAME, owner.getLastName());

    }
}