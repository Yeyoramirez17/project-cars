package com.project.cars.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table( name = "clientes")
@Getter
@Setter
public class CustomerEntity {

    @Id
    @Column( name = "cedula")
    private String cardId;

    @Column( name = "nombre_completo" )
    private String fullName;

    @Column(name = "correo")
    private String email;

    @Column(name = "numero_celular")
    private Double numberCellPhone;

    @Column(name = "activo")
    private Integer active;

    @Column(name = "contrasenia")
    private String password;

    private String rol;

    @OneToMany( mappedBy = "customerEntity")
    private List<PurchaseEntity> purchaseEntity;

}
