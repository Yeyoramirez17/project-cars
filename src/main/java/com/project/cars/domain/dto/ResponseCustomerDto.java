package com.project.cars.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseCustomerDto {

    private String password;

    public ResponseCustomerDto( String password ) {
        this.password = password;
    }
}
