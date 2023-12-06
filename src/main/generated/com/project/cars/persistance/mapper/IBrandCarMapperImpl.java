package com.project.cars.persistance.mapper;

import com.project.cars.domain.dto.BrandCarDto;
import com.project.cars.persistance.entity.BrandCarEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-16T22:42:41-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.5 (Amazon.com Inc.)"
)
@Component
public class IBrandCarMapperImpl implements IBrandCarMapper {

    @Override
    public BrandCarDto toBrandCarDto(BrandCarEntity entity) {
        if ( entity == null ) {
            return null;
        }

        BrandCarDto brandCarDto = new BrandCarDto();

        brandCarDto.setId( entity.getId() );
        brandCarDto.setDescription( entity.getDescription() );

        return brandCarDto;
    }

    @Override
    public BrandCarEntity toBrandCarEntity(BrandCarDto dto) {
        if ( dto == null ) {
            return null;
        }

        BrandCarEntity brandCarEntity = new BrandCarEntity();

        brandCarEntity.setId( dto.getId() );
        brandCarEntity.setDescription( dto.getDescription() );

        return brandCarEntity;
    }

    @Override
    public List<BrandCarDto> toBrandCarsDtos(List<BrandCarEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<BrandCarDto> list1 = new ArrayList<BrandCarDto>( list.size() );
        for ( BrandCarEntity brandCarEntity : list ) {
            list1.add( toBrandCarDto( brandCarEntity ) );
        }

        return list1;
    }
}
