package com.project.cars.domain.service;

import com.project.cars.domain.dto.CustomerDto;
import com.project.cars.domain.dto.ResponseCustomerDto;
import com.project.cars.domain.repository.ICustomerRepository;
import com.project.cars.domain.usecase.ICustomerUseCase;
import com.project.cars.exception.CustomerExistsException;
import com.project.cars.exception.EmailValidationException;
import com.project.cars.security.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerUseCaseImpl implements ICustomerUseCase {

    private final ICustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<CustomerDto> getAll() {
        return customerRepository.getAll();
    }

    @Override
    public Optional<CustomerDto> getCustomerByCardId(String cardId) {
        return this.customerRepository.getCustomerByCardId(cardId);
    }

    @Override
    public Optional<CustomerDto> getCustomerByEmail(String email) {
        return this.customerRepository.getCustomerByEmail(email);
    }

    @Override
    public ResponseCustomerDto save(CustomerDto newCustomer) {

        if( !newCustomer.getEmail().matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9_-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")) {
            throw new EmailValidationException();
        }
        String passwordGenerated = newCustomer.getPassword();

        if( newCustomer.getPassword() == null || newCustomer.getPassword().isEmpty() ) {
            passwordGenerated = this.generateRandomPassword(8);
            newCustomer.setPassword( passwordEncoder.encode(passwordGenerated) );
        }

        if( getCustomerByCardId( newCustomer.getCardId() ).isPresent() || getCustomerByEmail( newCustomer.getEmail() ).isPresent() ) {
            throw new CustomerExistsException();
        }

        newCustomer.setPassword( passwordEncoder.encode(newCustomer.getPassword()) );
        newCustomer.setActive( 1 );
        newCustomer.setRol( Role.CUSTOMER );
        this.customerRepository.save(newCustomer);

        return new ResponseCustomerDto( passwordGenerated );
    }

    @Override
    public Optional<CustomerDto> update(CustomerDto dto) {
        if( this.customerRepository.getCustomerByCardId( dto.getCardId()).isEmpty() ) {
            return Optional.empty();
        }
        return Optional.of( this.customerRepository.save( dto ));
    }

    @Override
    public boolean delete(String cardId) {
        if( this.customerRepository.getCustomerByCardId( cardId ).isEmpty()) {
            return false;
        }
        this.customerRepository.delete(cardId);
        return true;
    }

    // Método para generar una contraseña alfanumérica aleatoria de una logintud especifica
    private String generateRandomPassword( int length ) {
        final String chars = "ABCDEFGHIJKLMNOPPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt( chars.length());
            sb.append( chars.charAt(randomIndex) );
        }

        return sb.toString();
    }
}
