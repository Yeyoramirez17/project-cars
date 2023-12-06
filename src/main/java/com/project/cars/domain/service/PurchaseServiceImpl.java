package com.project.cars.domain.service;

import com.project.cars.domain.dto.CarDto;
import com.project.cars.domain.dto.PurchaseBillResponseDto;
import com.project.cars.domain.dto.PurchaseRequestDto;
import com.project.cars.domain.dto.PurchaseResponseDto;
import com.project.cars.domain.repository.ICarRepository;
import com.project.cars.domain.repository.IPurchaseRepository;
import com.project.cars.domain.usecase.IPurchaseUseCase;
import com.project.cars.exception.PurchaseNotExistException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PurchaseServiceImpl implements IPurchaseUseCase {

    private final IPurchaseRepository purchaseRepository;
    private final ICarRepository carRepository;

    @Override
    public List<PurchaseResponseDto> getAll() {
        return this.purchaseRepository.getAll();
    }

    @Override
    public List<PurchaseResponseDto> getByIdCustomer(String idCustomer) {
        return this.purchaseRepository.getByIdCustomer(idCustomer);
    }

    @Override
    public PurchaseResponseDto getByNumberBill(Integer numberBill) {
        PurchaseResponseDto purchaseResponseDto = purchaseRepository.getByNumberBill(numberBill);

        if (purchaseResponseDto == null) {
            throw new PurchaseNotExistException();
        }

        return purchaseResponseDto;
    }

    @Override
    public PurchaseBillResponseDto save(PurchaseRequestDto purchaseRequestDto) {
        PurchaseBillResponseDto billResponseDto = purchaseRepository.save(purchaseRequestDto);

        purchaseRequestDto.getCarsPurchases().forEach(carPurchase -> {
            CarDto carActual = carRepository.getCar(carPurchase.getCodeCar()).get();

            carActual.setStock(carActual.getStock() - carPurchase.getQuantity());

            carRepository.save(carActual);
        });

        return billResponseDto;
    }
}
