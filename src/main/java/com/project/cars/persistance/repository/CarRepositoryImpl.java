package com.project.cars.persistance.repository;

import com.project.cars.domain.dto.CarDto;
import com.project.cars.domain.repository.ICarRepository;
import com.project.cars.persistance.crud.ICarCrudRepository;
import com.project.cars.persistance.mapper.ICarMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CarRepositoryImpl implements ICarRepository {

    private final ICarCrudRepository crudRepository;
    private final ICarMapper mapper;

    @Override
    public List<CarDto> getAll() {
        return this.mapper.toCarDtoList( this.crudRepository.findAll() );
    }

    @Override
    public List<CarDto> getByIdBrandCar(Integer carId) {
        return this.mapper.toCarDtoList( this.crudRepository.findAllByBrandCarId( carId ) );
    }

    @Override
    public List<CarDto> getCarsByPriceLessThan(Double price) {
        return this.mapper.toCarDtoList( this.crudRepository.findAllByPriceLessThanOrderByPriceDesc( price ) );
    }

    @Override
    public Optional<CarDto> getCar(Integer carId) {
        return this.crudRepository.findById( carId )
                .map( this.mapper::toCarDto );
    }

    @Override
    public CarDto save(CarDto carDto) {
        return this.mapper.toCarDto(
                this.crudRepository.save(
                        this.mapper.toCarEntity( carDto )
                )
        );
    }

    @Override
    public void delete(Integer id) {
        this.crudRepository.deleteById( id );
    }
}
