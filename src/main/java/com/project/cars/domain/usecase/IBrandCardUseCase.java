package com.project.cars.domain.usecase;

import com.project.cars.domain.dto.BrandCarDto;

import java.util.List;
import java.util.Optional;

public interface IBrandCardUseCase {

    /**
     *  Retorna una lista con todos las marcas de coches
     * @return <List<BrandCarPojo>
     */
    List<BrandCarDto> getAll();

    /**
     * Devuelve una marca de coche dada por si ID
     * @param id Identificador de la Marca de Coche
     * @return Optional<BrandCarPojo>
     */
    Optional<BrandCarDto> getBrandCar(Integer id );

    /**
     * Persiste en la base de atos una Marca de de Coche
     * @param newBrandCar Marca de coche
     * @return BrandCarPojo
     */
    BrandCarDto save(BrandCarDto newBrandCar );

    /**
     * Actualiza una marca de Coche
     * @param updateBrandCarPojo
     * @return BrandCarPojo Marca de coche
     */
    Optional<BrandCarDto> update(BrandCarDto updateBrandCarPojo );
    /**
     * Elimina una Marca de Coche
     * @param id Indentificador del Coche
     */
    boolean delete( Integer id );
}
