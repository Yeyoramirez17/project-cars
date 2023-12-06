package com.project.cars.persistance.mapper;

import com.project.cars.domain.dto.CarDto;
import com.project.cars.persistance.entity.BrandCarEntity;
import com.project.cars.persistance.entity.CarEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-16T22:42:42-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.5 (Amazon.com Inc.)"
)
@Component
public class ICarMapperImpl implements ICarMapper {

    @Override
    public CarDto toCarDto(CarEntity entity) {
        if ( entity == null ) {
            return null;
        }

        CarDto carDto = new CarDto();

        carDto.setBrandCarString( entityBrandCarEntityDescription( entity ) );
        carDto.setCodeCar( entity.getCodeCar() );
        carDto.setBrandCarId( entity.getBrandCarId() );
        carDto.setReference( entity.getReference() );
        carDto.setPrice( entity.getPrice() );
        carDto.setModelYear( entity.getModelYear() );
        carDto.setColor( entity.getColor() );
        carDto.setHorsepower( entity.getHorsepower() );
        carDto.setNumberDoor( entity.getNumberDoor() );
        carDto.setEngineDisplacement( entity.getEngineDisplacement() );
        carDto.setTransmission( entity.getTransmission() );
        carDto.setFuelType( entity.getFuelType() );
        carDto.setNumberSeat( entity.getNumberSeat() );
        carDto.setTraction( entity.getTraction() );
        carDto.setSteering( entity.getSteering() );
        carDto.setCategory( entity.getCategory() );
        carDto.setImagePath( entity.getImagePath() );
        carDto.setStock( entity.getStock() );

        return carDto;
    }

    @Override
    public CarEntity toCarEntity(CarDto dto) {
        if ( dto == null ) {
            return null;
        }

        CarEntity carEntity = new CarEntity();

        carEntity.setCodeCar( dto.getCodeCar() );
        carEntity.setBrandCarId( dto.getBrandCarId() );
        carEntity.setReference( dto.getReference() );
        carEntity.setPrice( dto.getPrice() );
        carEntity.setModelYear( dto.getModelYear() );
        carEntity.setColor( dto.getColor() );
        carEntity.setHorsepower( dto.getHorsepower() );
        carEntity.setNumberDoor( dto.getNumberDoor() );
        carEntity.setEngineDisplacement( dto.getEngineDisplacement() );
        carEntity.setTransmission( dto.getTransmission() );
        carEntity.setFuelType( dto.getFuelType() );
        carEntity.setNumberSeat( dto.getNumberSeat() );
        carEntity.setTraction( dto.getTraction() );
        carEntity.setSteering( dto.getSteering() );
        carEntity.setCategory( dto.getCategory() );
        carEntity.setImagePath( dto.getImagePath() );
        carEntity.setStock( dto.getStock() );

        return carEntity;
    }

    @Override
    public List<CarDto> toCarDtoList(List<CarEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<CarDto> list1 = new ArrayList<CarDto>( list.size() );
        for ( CarEntity carEntity : list ) {
            list1.add( toCarDto( carEntity ) );
        }

        return list1;
    }

    private String entityBrandCarEntityDescription(CarEntity carEntity) {
        if ( carEntity == null ) {
            return null;
        }
        BrandCarEntity brandCarEntity = carEntity.getBrandCarEntity();
        if ( brandCarEntity == null ) {
            return null;
        }
        String description = brandCarEntity.getDescription();
        if ( description == null ) {
            return null;
        }
        return description;
    }
}
