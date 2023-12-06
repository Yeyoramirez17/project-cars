package com.project.cars.controller;

import com.project.cars.domain.dto.CarDto;
import com.project.cars.domain.usecase.ICarUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping( path = "/cars")
public class CarController {

    private final ICarUseCase carUseCase;

    @GetMapping()
    public ResponseEntity<List<CarDto>> findAll() {
        return ResponseEntity.ok( this.carUseCase.getAll() );
    }

    @GetMapping( path = "/brand-car/{idBrandCar}")
    public ResponseEntity<List<CarDto>> getByIdBrandCar(@PathVariable Integer idBrandCar ) {
        return ResponseEntity.ok( this.carUseCase.getByIdBrandCar( idBrandCar ) );
    }

    @GetMapping( path = "/price/{price}")
    public ResponseEntity<List<CarDto>> getCarsByPriceLessThan(@PathVariable Double price ) {
        return ResponseEntity.ok( this.carUseCase.getCarsByPriceLessThan( price ) );
    }

    @GetMapping( path = "/{idCar}")
    public ResponseEntity<CarDto> getCar(@PathVariable Integer idCar ) {
        return ResponseEntity.of( this.carUseCase.getCar( idCar ) );
    }

    @PostMapping()
    public ResponseEntity<CarDto> save( @RequestBody CarDto dto ) {
        return ResponseEntity.status(HttpStatus.CREATED )
                .body( this.carUseCase.save( dto ));
    }

    @DeleteMapping()
    public ResponseEntity<Boolean> delete( @PathVariable Integer carId) {
        return new ResponseEntity<>( this.carUseCase.delete( carId ) ? HttpStatus.OK : HttpStatus.NOT_FOUND );
    }
}
