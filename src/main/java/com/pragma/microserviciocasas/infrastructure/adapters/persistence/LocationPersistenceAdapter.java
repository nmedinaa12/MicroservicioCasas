package com.pragma.microserviciocasas.infrastructure.adapters.persistence;


import com.pragma.microserviciocasas.domain.model.LocationModel;
import com.pragma.microserviciocasas.domain.ports.out.LocationPersistencePort;
import com.pragma.microserviciocasas.infrastructure.mappers.LocationEntityMapper;
import com.pragma.microserviciocasas.infrastructure.repositories.mysql.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class LocationPersistenceAdapter implements LocationPersistencePort {
    private final LocationRepository locationRepository;
    private final LocationEntityMapper locationEntityMapper;

    @Override
    public void save(LocationModel locationModel) {
        locationRepository.save(locationEntityMapper.modelToEntity(locationModel));
    }

    @Override
    public LocationModel findByDepartmentAndCity(String locationDepartment, String locationCity) {
        return locationEntityMapper.entityToModel(locationRepository.findByDepartmentAndCity(locationDepartment,locationCity).orElse(null));
    }
}