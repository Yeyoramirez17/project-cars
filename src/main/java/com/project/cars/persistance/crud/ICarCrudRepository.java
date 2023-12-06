package com.project.cars.persistance.crud;

import com.project.cars.persistance.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICarCrudRepository extends JpaRepository<CarEntity, Integer> {

    List<CarEntity> findAllByBrandCarId(Integer brandCarId );
    List<CarEntity> findAllByPriceLessThanOrderByPriceDesc(Double price );

}
