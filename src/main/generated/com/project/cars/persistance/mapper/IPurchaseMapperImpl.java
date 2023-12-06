package com.project.cars.persistance.mapper;

import com.project.cars.domain.dto.CarPurchaseRequestDto;
import com.project.cars.domain.dto.PurchaseRequestDto;
import com.project.cars.persistance.entity.CarPurchaseEntity;
import com.project.cars.persistance.entity.PurchaseEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-16T22:42:41-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.5 (Amazon.com Inc.)"
)
@Component
public class IPurchaseMapperImpl implements IPurchaseMapper {

    @Autowired
    private ICarPurchaseMapper iCarPurchaseMapper;

    @Override
    public PurchaseEntity toPurchaseEntity(PurchaseRequestDto requestDto) {
        if ( requestDto == null ) {
            return null;
        }

        PurchaseEntity purchaseEntity = new PurchaseEntity();

        purchaseEntity.setNumberBill( requestDto.getNumberBill() );
        purchaseEntity.setCardIdCustomer( requestDto.getCardIdCustomer() );
        purchaseEntity.setDate( requestDto.getDate() );
        purchaseEntity.setTotal( requestDto.getTotal() );
        purchaseEntity.setPaymentMethod( requestDto.getPaymentMethod() );
        purchaseEntity.setCarsPurchases( carPurchaseRequestDtoListToCarPurchaseEntityList( requestDto.getCarsPurchases() ) );

        return purchaseEntity;
    }

    protected List<CarPurchaseEntity> carPurchaseRequestDtoListToCarPurchaseEntityList(List<CarPurchaseRequestDto> list) {
        if ( list == null ) {
            return null;
        }

        List<CarPurchaseEntity> list1 = new ArrayList<CarPurchaseEntity>( list.size() );
        for ( CarPurchaseRequestDto carPurchaseRequestDto : list ) {
            list1.add( iCarPurchaseMapper.toCarPurchaseEntity( carPurchaseRequestDto ) );
        }

        return list1;
    }
}
