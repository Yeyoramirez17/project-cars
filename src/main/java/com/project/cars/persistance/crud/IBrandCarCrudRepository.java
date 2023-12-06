package com.project.cars.persistance.crud;

import com.project.cars.persistance.entity.BrandCarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBrandCarCrudRepository extends JpaRepository<BrandCarEntity, Integer> {

}
