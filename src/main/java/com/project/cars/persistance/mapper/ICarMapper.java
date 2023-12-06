package com.project.cars.persistance.mapper;

import com.project.cars.domain.dto.CarDto;
import com.project.cars.persistance.entity.CarEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper( componentModel = "spring")
public interface ICarMapper {

    @Mapping(source = "brandCarEntity.description", target = "brandCarString")
    CarDto toCarDto(CarEntity entity );

    @Mapping( target = "brandCarEntity", ignore = true)
    @Mapping( target = "carPurchaseEntity", ignore = true)
    CarEntity toCarEntity(CarDto dto);

    List<CarDto> toCarDtoList(List<CarEntity> list );
}
