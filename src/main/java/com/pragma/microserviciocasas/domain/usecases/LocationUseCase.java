package com.pragma.microserviciocasas.domain.usecases;


import com.pragma.microserviciocasas.domain.exceptions.LocationAlreadyExistsException;
import com.pragma.microserviciocasas.domain.model.LocationModel;
import com.pragma.microserviciocasas.domain.ports.in.LocationServicePort;
import com.pragma.microserviciocasas.domain.ports.out.LocationPersistencePort;


public class LocationUseCase implements LocationServicePort {
    private final LocationPersistencePort locationPersistencePort;


    public LocationUseCase(LocationPersistencePort locationPersistencePort){
        this.locationPersistencePort = locationPersistencePort;
    }


    @Override
    public void save(LocationModel locationModel) {
        LocationModel existingLocation = locationPersistencePort.findByDepartmentAndCity(
                locationModel.getDepartment(),
                locationModel.getCity()
        );

        if (existingLocation != null) {
            throw new LocationAlreadyExistsException();
        }
        locationPersistencePort.save(locationModel);
    }

}
