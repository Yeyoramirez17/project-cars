package com.project.cars.domain.service;

import com.project.cars.domain.dto.BrandCarDto;
import com.project.cars.domain.repository.IBrandCarRepository;
import com.project.cars.domain.usecase.IBrandCardUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Brand Car implement IbrandCardService
 */
@RequiredArgsConstructor
@Transactional
@Service
public class BrandCarUseCaseImpl implements IBrandCardUseCase {

    private final IBrandCarRepository iBrandCarRepository;

    @Override
    public List<BrandCarDto> getAll() {
        return this.iBrandCarRepository.getAll();
    }

    @Override
    public Optional<BrandCarDto> getBrandCar(Integer id) {
        return this.iBrandCarRepository.getBrandCar(id);
    }

    @Override
    public BrandCarDto save(BrandCarDto newBrandCar) {
        return this.iBrandCarRepository.save( newBrandCar );
    }

    @Override
    public Optional<BrandCarDto> update(BrandCarDto updateBrandCarPojo) {
        if( this.iBrandCarRepository.getBrandCar( updateBrandCarPojo.getId() ).isEmpty() )
        {
            return Optional.empty();
        }
        return Optional.of(this.iBrandCarRepository.save( updateBrandCarPojo ));
    }

    /**
     * Retorna true sí se elimino, false de lo contrario
     * @param id Indentificador del Coche
     * @return boolean
     */
    @Override
    public boolean delete(Integer id) {

        if( this.iBrandCarRepository.getBrandCar( id ).isEmpty() )
        {
            return false;
        }

        this.iBrandCarRepository.delete( id );
        return true;

    }
}
