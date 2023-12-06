package com.project.cars.controller;

import com.project.cars.domain.dto.PurchaseBillResponseDto;
import com.project.cars.domain.dto.PurchaseRequestDto;
import com.project.cars.domain.dto.PurchaseResponseDto;
import com.project.cars.domain.usecase.IPurchaseUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/purchases")
public class PurchaseController {

    private final IPurchaseUseCase purchaseUseCase;

    @GetMapping()
    public ResponseEntity<List<PurchaseResponseDto>> getAll() {
        return ResponseEntity.ok( purchaseUseCase.getAll() );
    }

    @GetMapping(path = "/customers/{cardId}")
    public ResponseEntity<List<PurchaseResponseDto>> getPurchasesByIdCustomer(@PathVariable String cardId) {
        return ResponseEntity.ok( purchaseUseCase.getByIdCustomer(cardId) );
    }

    @GetMapping(path = "/{numberBill}")
    public ResponseEntity<PurchaseResponseDto> getPurchasesByNumberBill(@PathVariable Integer numberBill) {
        return ResponseEntity.ok( purchaseUseCase.getByNumberBill(numberBill) );
    }

    @PostMapping()
    public ResponseEntity<PurchaseBillResponseDto> savePurchase(@RequestBody PurchaseRequestDto purchaseRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body( purchaseUseCase.save(purchaseRequestDto) );
    }

}
