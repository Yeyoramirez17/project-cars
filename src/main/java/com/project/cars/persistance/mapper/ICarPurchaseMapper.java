package com.project.cars.persistance.mapper;

import com.project.cars.domain.dto.CarPurchaseRequestDto;
import com.project.cars.persistance.entity.CarPurchaseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper de coches compras
 */
@Mapper(componentModel = "spring")
public interface ICarPurchaseMapper {

    @Mapping( target = "id.codeCar", source = "codeCar" )
    @Mapping( target = "purchaseEntity", ignore = true )
    @Mapping( target = "carEntity", ignore = true )
    @Mapping( target = "id.purchaseNumberBill", ignore = true )
    CarPurchaseEntity toCarPurchaseEntity(CarPurchaseRequestDto carPurchaseRequestDto);
}