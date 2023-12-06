package com.project.cars.domain.usecase;

import com.project.cars.domain.dto.PurchaseBillResponseDto;
import com.project.cars.domain.dto.PurchaseRequestDto;
import com.project.cars.domain.dto.PurchaseResponseDto;

import java.util.List;

public interface IPurchaseUseCase {

    List<PurchaseResponseDto> getAll();

    List<PurchaseResponseDto> getByIdCustomer(String idCustomer);

    PurchaseResponseDto getByNumberBill(Integer numberBill);

    PurchaseBillResponseDto save(PurchaseRequestDto purchaseRequestDto);
}
