package com.project.cars.persistance.repository;

import com.project.cars.domain.dto.CustomerDto;
import com.project.cars.domain.repository.ICustomerRepository;
import com.project.cars.persistance.crud.ICustomerCrudRepository;
import com.project.cars.persistance.entity.CustomerEntity;
import com.project.cars.persistance.mapper.ICustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CustomerRepositoryImpl implements ICustomerRepository {

    private final ICustomerCrudRepository iCustomerCrudRepository;
    private final ICustomerMapper mapper;

    @Override
    public List<CustomerDto> getAll() {
        return this.mapper.toCustomersDtoList(
                this.iCustomerCrudRepository.findAll()
        );
    }

    @Override
    public Optional<CustomerDto> getCustomerByCardId(String cardId) {
        return this.iCustomerCrudRepository.findById( cardId )
                .map( mapper::toCustomerDto );
    }

    @Override
    public Optional<CustomerDto> getCustomerByEmail(String email) {
        return this.iCustomerCrudRepository.findByEmail( email )
                .map( mapper::toCustomerDto );
    }

    @Override
    public CustomerDto save(CustomerDto newCustomer) {
        CustomerEntity entity = this.mapper.toCustomerEntity( newCustomer );

        return mapper.toCustomerDto(
                iCustomerCrudRepository.save(
                        entity
                )
        );
    }

    @Override
    public void delete(String cardId) {
        this.iCustomerCrudRepository.deleteById(cardId);
    }
}
