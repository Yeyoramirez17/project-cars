package com.project.cars.persistance.mapper;

import com.project.cars.domain.dto.CustomerDto;
import com.project.cars.persistance.entity.CustomerEntity;
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
public class ICustomerMapperImpl implements ICustomerMapper {

    @Override
    public CustomerDto toCustomerDto(CustomerEntity entity) {
        if ( entity == null ) {
            return null;
        }

        CustomerDto customerDto = new CustomerDto();

        customerDto.setCardId( entity.getCardId() );
        customerDto.setFullName( entity.getFullName() );
        customerDto.setEmail( entity.getEmail() );
        customerDto.setNumberCellPhone( entity.getNumberCellPhone() );
        customerDto.setActive( entity.getActive() );
        customerDto.setPassword( entity.getPassword() );
        customerDto.setRol( entity.getRol() );

        return customerDto;
    }

    @Override
    public CustomerEntity toCustomerEntity(CustomerDto dto) {
        if ( dto == null ) {
            return null;
        }

        CustomerEntity customerEntity = new CustomerEntity();

        customerEntity.setCardId( dto.getCardId() );
        customerEntity.setFullName( dto.getFullName() );
        customerEntity.setEmail( dto.getEmail() );
        customerEntity.setNumberCellPhone( dto.getNumberCellPhone() );
        customerEntity.setActive( dto.getActive() );
        customerEntity.setPassword( dto.getPassword() );
        customerEntity.setRol( dto.getRol() );

        return customerEntity;
    }

    @Override
    public List<CustomerDto> toCustomersDtoList(List<CustomerEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<CustomerDto> list1 = new ArrayList<CustomerDto>( list.size() );
        for ( CustomerEntity customerEntity : list ) {
            list1.add( toCustomerDto( customerEntity ) );
        }

        return list1;
    }
}
