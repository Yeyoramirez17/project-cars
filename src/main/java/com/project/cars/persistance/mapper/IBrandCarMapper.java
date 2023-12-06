package com.project.cars.persistance.mapper;

import com.project.cars.domain.dto.BrandCarDto;
import com.project.cars.persistance.entity.BrandCarEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Mapper MarcaCoche
 */
@Mapper( componentModel = "spring")
public interface IBrandCarMapper {

    /**
     * Convierte una entidad a un pojo de MarcaCoche
     */
    @Mapping( source = "entity.id", target = "id")
    @Mapping( source = "entity.description", target = "description")
    BrandCarDto toBrandCarDto(BrandCarEntity entity);
    /**
     * Convierte un Pojo a una Entidad de MarcaCoche
     */
    @InheritInverseConfiguration
    @Mapping( target = "carEntities", ignore = true)
    BrandCarEntity toBrandCarEntity(BrandCarDto dto);

    List<BrandCarDto> toBrandCarsDtos(List<BrandCarEntity> list);
}
