package com.project.cars.controller;

import com.project.cars.domain.dto.AuthCustomerDto;
import com.project.cars.domain.dto.CustomerDto;
import com.project.cars.domain.dto.JwtResponseDto;
import com.project.cars.domain.dto.ResponseCustomerDto;
import com.project.cars.domain.usecase.IAuthUseCase;
import com.project.cars.domain.usecase.ICustomerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping( path = "/auth" )
public class AuthController {

    private final IAuthUseCase authUseCase;
    private final ICustomerUseCase customerUseCase;

    @PostMapping(path = "/register")
    public ResponseEntity<ResponseCustomerDto> save(@RequestBody CustomerDto customerDtoNew) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body( customerUseCase.save(customerDtoNew) );
    }

    @PostMapping( path = "/sign-in" )
    public ResponseEntity<JwtResponseDto> signIn(@RequestBody AuthCustomerDto dto ) {
        return ResponseEntity.ok( authUseCase.signIn( dto) );
    }

    @PostMapping( path = "/sign-out" )
    public ResponseEntity<JwtResponseDto> signOut(@RequestHeader( name = HttpHeaders.AUTHORIZATION) String jwt) {
        return ResponseEntity.ok( authUseCase.signOut( jwt ) );
    }
}
