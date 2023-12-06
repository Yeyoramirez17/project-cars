package com.project.cars.domain.usecase;

import com.project.cars.domain.dto.AuthCustomerDto;
import com.project.cars.domain.dto.JwtResponseDto;

public interface IAuthUseCase {

    JwtResponseDto signIn(AuthCustomerDto dto );
    JwtResponseDto signOut( String jwt );

}
