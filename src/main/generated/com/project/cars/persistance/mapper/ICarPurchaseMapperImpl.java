package com.project.cars.persistance.mapper;

import com.project.cars.domain.dto.CarPurchaseRequestDto;
import com.project.cars.persistance.entity.CarPurchaseEntity;
import com.project.cars.persistance.entity.CarPurchasePK;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-16T22:42:42-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.5 (Amazon.com Inc.)"
)
@Component
public class ICarPurchaseMapperImpl implements ICarPurchaseMapper {

    @Override
    public CarPurchaseEntity toCarPurchaseEntity(CarPurchaseRequestDto carPurchaseRequestDto) {
        if ( carPurchaseRequestDto == null ) {
            return null;
        }

        CarPurchaseEntity carPurchaseEntity = new CarPurchaseEntity();

        carPurchaseEntity.setId( carPurchaseRequestDtoToCarPurchasePK( carPurchaseRequestDto ) );
        carPurchaseEntity.setQuantity( carPurchaseRequestDto.getQuantity() );
        carPurchaseEntity.setTotal( carPurchaseRequestDto.getTotal() );

        return carPurchaseEntity;
    }

    protected CarPurchasePK carPurchaseRequestDtoToCarPurchasePK(CarPurchaseRequestDto carPurchaseRequestDto) {
        if ( carPurchaseRequestDto == null ) {
            return null;
        }

        CarPurchasePK carPurchasePK = new CarPurchasePK();

        carPurchasePK.setCodeCar( carPurchaseRequestDto.getCodeCar() );

        return carPurchasePK;
    }
}
