package com.project.cars.domain.usecase;

import com.project.cars.domain.dto.CustomerDto;
import com.project.cars.domain.dto.ResponseCustomerDto;

import java.util.List;
import java.util.Optional;

public interface ICustomerUseCase {

    /**
     *  Retorna una lista con todos los Clientes
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
     * Devuelve un Cliente según su E-mail
     * @param email Identificador del Cliente
     * @return Optional<CustomerDto>
     */
    Optional<CustomerDto> getCustomerByEmail(String email );

    /**
     * Persiste en la base de datos un Cliente
     * @param newCustomer Cliente
     * @return BrandCarPojo
     */
    ResponseCustomerDto save(CustomerDto newCustomer );

    /**
     * Actualiza una Cliente
     * @param dto CustomerDto
     * @return BrandCarPojo Marca de coche
     */
    Optional<CustomerDto> update(CustomerDto dto );

    /**
     * Elimina un Cliente
     * @param cardId Indentificador del Cliente
     */
    boolean delete( String cardId );
}
