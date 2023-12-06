package com.project.cars.persistance.crud;

import com.project.cars.persistance.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICustomerCrudRepository extends JpaRepository<CustomerEntity, String> {

    // Query method
    Optional<CustomerEntity> findByEmail(String email);
}
