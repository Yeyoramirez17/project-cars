package com.project.cars.domain.repository;

import com.project.cars.domain.dto.BrandCarDto;
import com.project.cars.domain.dto.CustomerDto;

import java.util.List;
import java.util.Optional;

public interface ICustomerRepository {

    /**
     *  Retorna una lista con todos las marcas de coches
     * @return List<CustomerDto>
     */
    List<CustomerDto> getAll();

    /**
     * Devuelve un Cliente según si ID
     * @param cardId Identificador del Cliente
     * @return Optional<CustomerDto>
     */
    Optional<CustomerDto> getCustomerByCardId(String cardId );

    /**
     * Devuelve un Cliente según si E-mail
     * @param email Identificador del Cliente
     * @return Optional<CustomerDto>
     */
    Optional<CustomerDto> getCustomerByEmail(String email );

    /**
     * Persiste en la base de datos un Cliente
     * @param newCustomer Cliente
     * @return BrandCarPojo
     */
    CustomerDto save(CustomerDto newCustomer );

    /**
     * Elimina un Cliente
     * @param cardId Indentificador del Cliente
     */
    void delete( String cardId );

}
