package com.spring.springcourselearningpetclinic.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "pet_types")
public class PetType extends BaseEntity{

    @Column(name = "name")
    private String name;

    @Override
    public String toString() {
        return name;
    }
}
