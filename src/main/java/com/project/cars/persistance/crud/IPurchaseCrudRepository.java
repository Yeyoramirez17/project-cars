package com.project.cars.persistance.crud;

import com.project.cars.persistance.entity.PurchaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPurchaseCrudRepository extends JpaRepository<PurchaseEntity, Integer> {

    List<PurchaseEntity> findAllByCardIdCustomer(String id);

}
