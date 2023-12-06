package com.project.cars.persistance.mapper;

import com.project.cars.domain.dto.PurchaseRequestDto;
import com.project.cars.persistance.entity.PurchaseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper( componentModel = "spring" , uses = { ICarPurchaseMapper.class } )
public interface IPurchaseMapper {

    @Mapping( target = "customerEntity", ignore = true )
    PurchaseEntity toPurchaseEntity( PurchaseRequestDto requestDto );

}
