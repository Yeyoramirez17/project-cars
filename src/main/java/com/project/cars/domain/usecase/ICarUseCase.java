package com.project.cars.domain.usecase;

import com.project.cars.domain.dto.CarDto;

import java.util.List;
import java.util.Optional;

public interface ICarUseCase {


    List<CarDto> getAll();

    List<CarDto> getByIdBrandCar( Integer carId );

    List<CarDto> getCarsByPriceLessThan( Double price );

    Optional<CarDto> getCar(Integer carId );

    CarDto save( CarDto carDto);

    Boolean delete( Integer carId );

}
