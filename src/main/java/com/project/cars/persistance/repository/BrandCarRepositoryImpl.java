package com.project.cars.persistance.repository;


import com.project.cars.domain.dto.BrandCarDto;
import com.project.cars.domain.repository.IBrandCarRepository;
import com.project.cars.persistance.crud.IBrandCarCrudRepository;
import com.project.cars.persistance.mapper.IBrandCarMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository Brand Card
 */
@RequiredArgsConstructor
@Repository
public class BrandCarRepositoryImpl implements IBrandCarRepository {

    private final IBrandCarCrudRepository iBrandCarCrudRepository;
    private final IBrandCarMapper iBrandCarMapper;

    @Override
    public List<BrandCarDto> getAll() {
        /*
        return this.iBrandCarCrudRepository.findAll()
                .stream()
                .map(this.iBrandCarMapper::toBrandCarPojo)
                .collect(Collectors.toList());
        */
        return this.iBrandCarMapper.toBrandCarsDtos( this.iBrandCarCrudRepository.findAll() );
    }

    /**
     * Devuelve un BrandCardPojo opor su ID
     * @param id Identificador de la Marca de Coche
     * @return Optional<BrandCarPojo>
     */
    @Override
    public Optional<BrandCarDto> getBrandCar(Integer id) {
        return this.iBrandCarCrudRepository.findById( id ).map( iBrandCarMapper::toBrandCarDto );
    }

    @Override
    public BrandCarDto save(BrandCarDto newBrandCar) {
        var brandCarEntity = this.iBrandCarMapper.toBrandCarEntity(newBrandCar);

        return this.iBrandCarMapper.toBrandCarDto(
                this.iBrandCarCrudRepository.save(
                        brandCarEntity
                )
        );
    }

    @Override
    public void delete(Integer id) {
        this.iBrandCarCrudRepository.deleteById( id );
    }
}
