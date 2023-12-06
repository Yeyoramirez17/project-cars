package com.project.cars.controller;

import com.project.cars.domain.dto.BrandCarDto;
import com.project.cars.domain.usecase.IBrandCardUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller Rest API Brand Car
 */
@RestController
@RequestMapping( path = "/brand-cars" )
@RequiredArgsConstructor
public class BrandCarController {

    private  final IBrandCardUseCase iBrandCardUseCase;

    @GetMapping
    public ResponseEntity<List<BrandCarDto> > getAll() {
        // return ResponseEntity.status(HttpStatus.OK)
        //         .body( this.iBrandCardService.getAll() );
        return ResponseEntity.ok( this.iBrandCardUseCase.getAll() );
    }

    @GetMapping(path = "/{id}")
    public  ResponseEntity<BrandCarDto> getBrandCar(@PathVariable(value = "id") Integer id ) {
        return ResponseEntity.of( this.iBrandCardUseCase.getBrandCar( id ) );
    }

    @PostMapping
    public ResponseEntity<BrandCarDto> save(@RequestBody BrandCarDto brandCarPojo ) {
        try{
            return ResponseEntity.status( HttpStatus.CREATED )
                    .body( this.iBrandCardUseCase.save( brandCarPojo ) );
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PatchMapping()
    public ResponseEntity<BrandCarDto> update(@RequestBody BrandCarDto brandCarPojo ) {

        return ResponseEntity.of( this.iBrandCardUseCase.update( brandCarPojo ));
    }

    @DeleteMapping( path = "/{id}")
    public ResponseEntity<Void> delete( @PathVariable(value = "id") Integer id  ) {

        if( ! this.iBrandCardUseCase.delete( id ) ) {
            return ResponseEntity.notFound().build();
        };
        return ResponseEntity.noContent().build();
    }
}
