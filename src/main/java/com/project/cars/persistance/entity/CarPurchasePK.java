package com.project.cars.persistance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Setter
@Getter
@Embeddable
public class CarPurchasePK implements Serializable {

    @Serial
    private static final long serialVersionUID = 9183895684208174682L;

    @Column( name = "compras_numero_factura" )
    private Integer purchaseNumberBill;

    @Column( name = "coche_codigo_coche" )
    private Integer codeCar;

}
