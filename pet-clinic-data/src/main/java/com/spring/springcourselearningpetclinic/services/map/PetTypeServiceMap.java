package com.spring.springcourselearningpetclinic.services.map;

import com.spring.springcourselearningpetclinic.model.PetType;
import com.spring.springcourselearningpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetTypeServiceMap extends AbstractMapService<PetType, Long> implements PetTypeService {
    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);

    }

    @Override
    public PetType save(PetType petType) {
        return super.save(petType);
    }

    @Override
    public void delete(PetType petType) {
        super.delete(petType);

    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }
}
