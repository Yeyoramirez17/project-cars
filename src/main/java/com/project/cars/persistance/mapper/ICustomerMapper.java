package com.project.cars.persistance.mapper;

import com.project.cars.domain.dto.CustomerDto;
import com.project.cars.persistance.entity.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper( componentModel = "spring")
public interface ICustomerMapper {


    CustomerDto toCustomerDto(CustomerEntity entity );

    @Mapping( target = "purchaseEntity", ignore = true )
    CustomerEntity toCustomerEntity(CustomerDto dto );

    List<CustomerDto> toCustomersDtoList( List<CustomerEntity> list );
}
