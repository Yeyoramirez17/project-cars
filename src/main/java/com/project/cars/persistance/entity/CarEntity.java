package com.project.cars.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "cars")
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_coche", nullable = false)
    private Integer codeCar;

    @Column(name = "marca_coche_id")
    private Integer brandCarId;

    @Column(name = "referencia")
    private String reference;

    @Column(name = "precio")
    private Double price;

    @Column(name = "anio_modelo")
    private Double modelYear;

    private String color;

    @Column(name = "numero_cabalos_fuerza")
    private Double horsepower;

    @Column(name = "cantidad_puertas")
    private Integer numberDoor;

    @Column(name = "cilindraje")
    private Double engineDisplacement;

    @Column(name = "transmision")
    private String transmission;

    @Column(name = "tipo_combustible")
    private String fuelType;

    @Column(name = "cantidad_asientos")
    private Integer numberSeat;

    @Column(name = "traccion")
    private Double traction;

    @Column(name = "direccion")
    private String steering;

    @Column(name = "categoria")
    private String category;
    
    @Column(name = "ruta_imagen")
    private String imagePath;

    private Integer stock;

    @ManyToOne
    @JoinColumn( name = "marca_coche_id", insertable = false, updatable = false )
    private BrandCarEntity brandCarEntity;

    @OneToMany( mappedBy = "carEntity" )
    private List<CarPurchaseEntity> carPurchaseEntity;

}
