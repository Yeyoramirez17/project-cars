package com.project.cars.persistance.repository;

import com.project.cars.domain.dto.CarPurchaseResponseDto;
import com.project.cars.domain.dto.PurchaseBillResponseDto;
import com.project.cars.domain.dto.PurchaseRequestDto;
import com.project.cars.domain.dto.PurchaseResponseDto;
import com.project.cars.domain.repository.IPurchaseRepository;
import com.project.cars.persistance.crud.IPurchaseCrudRepository;
import com.project.cars.persistance.entity.PurchaseEntity;
import com.project.cars.persistance.mapper.IPurchaseMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class PurchaseRepository implements IPurchaseRepository {

    private final IPurchaseCrudRepository repository;
    private final IPurchaseMapper mapper;

    @Override
    public List<PurchaseResponseDto> getAll() {
        List<PurchaseEntity> listPurchasesEntity = repository.findAll();
        List<PurchaseResponseDto> listPurchaseResponseDto = new ArrayList<>();

        listPurchasesEntity.forEach(purchaseEntity -> listPurchaseResponseDto.add(toPurchaseResponseDtoByEntity(purchaseEntity)));

        return listPurchaseResponseDto;
    }

    @Override
    public List<PurchaseResponseDto> getByIdCustomer(String idCustomer) {
        List<PurchaseEntity> listPurchasesEntity = repository.findAllByCardIdCustomer(idCustomer);
        List<PurchaseResponseDto> listPurchaseResponseDto = new ArrayList<>();

        listPurchasesEntity.forEach(purchaseEntity -> listPurchaseResponseDto.add(toPurchaseResponseDtoByEntity(purchaseEntity)));

        return listPurchaseResponseDto;
    }

    @Override
    public PurchaseResponseDto getByNumberBill(Integer numberBill) {
        Optional<PurchaseEntity> purchaseEntitySearch = repository.findById(numberBill);

        if(purchaseEntitySearch.isEmpty()) {
            return null;
        }

        return toPurchaseResponseDtoByEntity(purchaseEntitySearch.get());
    }

    @Override
    public PurchaseBillResponseDto save(PurchaseRequestDto purchaseRequestDto) {
        PurchaseEntity purchaseEntity = mapper.toPurchaseEntity(purchaseRequestDto);

        purchaseEntity.getCarsPurchases().forEach(carPurchaseEntity -> carPurchaseEntity.setPurchaseEntity(purchaseEntity));

        PurchaseEntity purchaseEntitySave = repository.save(purchaseEntity);
        return new PurchaseBillResponseDto(purchaseEntitySave.getNumberBill());
    }

    public PurchaseResponseDto toPurchaseResponseDtoByEntity(PurchaseEntity purchaseEntity) {
        PurchaseResponseDto purchaseResponseDto = new PurchaseResponseDto();
        purchaseResponseDto.setNumberBill(purchaseEntity.getNumberBill());
        purchaseResponseDto.setCardIdCustomer(purchaseEntity.getCardIdCustomer());
        purchaseResponseDto.setDate(purchaseEntity.getDate());
        purchaseResponseDto.setTotal(purchaseEntity.getTotal());
        purchaseResponseDto.setPaymentMethod(purchaseEntity.getPaymentMethod());

        List<CarPurchaseResponseDto> carPurchaseResponseDtoList = new ArrayList<>();
        purchaseEntity.getCarsPurchases().forEach(carPurchaseEntity -> {
            String reference = carPurchaseEntity.getCarEntity().getReference();
            Integer quantity = carPurchaseEntity.getQuantity();
            Integer total = carPurchaseEntity.getTotal();
            carPurchaseResponseDtoList.add(new CarPurchaseResponseDto(reference, quantity, total));
        });

        purchaseResponseDto.setCarsPurchase(carPurchaseResponseDtoList);

        return purchaseResponseDto;
    }
}
