package com.project.cars.domain.service;

import com.project.cars.domain.dto.CarDto;
import com.project.cars.domain.repository.ICarRepository;
import com.project.cars.domain.usecase.ICarUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements ICarUseCase {

    private final ICarRepository carRepository;

    @Override
    public List<CarDto> getAll() {
        return this.carRepository.getAll();
    }

    @Override
    public List<CarDto> getByIdBrandCar(Integer brandCarId) {
        return this.carRepository.getByIdBrandCar( brandCarId );
    }

    @Override
    public List<CarDto> getCarsByPriceLessThan(Double price) {
        return this.carRepository.getCarsByPriceLessThan( price );
    }

    @Override
    public Optional<CarDto> getCar(Integer carId) {
        return this.carRepository.getCar( carId );
    }

    @Override
    public CarDto save(CarDto carDto) {
        return this.carRepository.save( carDto );
    }

    @Override
    public Boolean delete(Integer carId) {
        if( this.carRepository.getCar( carId).isEmpty() ) {
            return false;
        }
        this.carRepository.delete( carId );
        return true;
    }
}
