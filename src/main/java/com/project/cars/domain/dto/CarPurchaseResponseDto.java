package com.project.cars.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class CarPurchaseResponseDto {

    public String referenceCar;
    private Integer quantity;
    private Integer total;

}
