package com.project.cars.controller;

import com.project.cars.domain.dto.CustomerDto;
import com.project.cars.domain.dto.ResponseCustomerDto;
import com.project.cars.domain.usecase.ICustomerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping( path = "/customers")
public class CustomerController {

    private final ICustomerUseCase customerService;

    @GetMapping
    public ResponseEntity<List<CustomerDto>> gelAll() {
        return ResponseEntity.ok( this.customerService.getAll());
    }

    @GetMapping( path = "/{cardId}")
    public ResponseEntity<CustomerDto> getCustomerByCardId( @PathVariable String cardId ) {
        return ResponseEntity.of( this.customerService.getCustomerByCardId( cardId ) );
    }

    @GetMapping( path = "/{email}")
    public ResponseEntity<CustomerDto> getCustomerByEmail( @PathVariable String email ) {
        return ResponseEntity.of( this.customerService.getCustomerByCardId( email ) );
    }

    @PostMapping
    public ResponseEntity<ResponseCustomerDto> save( @RequestBody CustomerDto newCustomer ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                    .body( this.customerService.save( newCustomer));
    }

    @PatchMapping
    public ResponseEntity<CustomerDto> update( @RequestBody CustomerDto dto ) {
        return ResponseEntity.of( this.customerService.update( dto )) ;
    }

    @DeleteMapping( path = "/{cardId}")
    public ResponseEntity<Void> delete( @PathVariable(value = "cardId") String cardId  ) {

        if( ! this.customerService.delete( cardId ) ) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
