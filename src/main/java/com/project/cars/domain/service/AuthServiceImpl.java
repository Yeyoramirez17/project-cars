package com.project.cars.domain.service;

import com.project.cars.domain.dto.AuthCustomerDto;
import com.project.cars.domain.dto.CustomerDto;
import com.project.cars.domain.dto.JwtResponseDto;
import com.project.cars.domain.repository.ICustomerRepository;
import com.project.cars.domain.usecase.IAuthUseCase;
import com.project.cars.exception.CustomerNotExistException;
import com.project.cars.exception.PasswordIncorrectException;
import com.project.cars.security.JwtAuthenticationProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements IAuthUseCase {

    private final ICustomerRepository customerRepository;
    private final JwtAuthenticationProvider authenticationProvider;
    private final PasswordEncoder passwordEncoder;


    @Override
    public JwtResponseDto signIn(AuthCustomerDto dto) {

        Optional<CustomerDto> customer = customerRepository.getCustomerByEmail( dto.getEmail() );

        if( customer.isEmpty()) {
            throw new CustomerNotExistException();
        }

        if( ! passwordEncoder.matches( dto.getPassword(), customer.get().getPassword() ) ){
            throw new PasswordIncorrectException();
        }
        return new JwtResponseDto( authenticationProvider.createToken( customer.get() ) );
    }

    @Override
    public JwtResponseDto signOut( String jwtToken ) {
        String[] authElements = jwtToken.split(" ");
        return new JwtResponseDto( authenticationProvider.deleteToken(authElements[1]  ));
    }
}
