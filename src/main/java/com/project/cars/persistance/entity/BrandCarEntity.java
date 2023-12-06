package com.project.cars.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Entidad MarcaCoche
 */
@Getter
@Setter
@Entity
@Table(name = "brand_car")
public class BrandCarEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;

    @Column( name = "description")
    private String description;

    @OneToMany( mappedBy = "brandCarEntity", orphanRemoval = true)
    private List<CarEntity> carEntities;

}
