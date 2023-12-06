package com.project.cars.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDto {

    private String cardId;
    private String fullName;
    private String email;
    private Double numberCellPhone;
    private Integer active;
    private String password;
    private String rol;

}
