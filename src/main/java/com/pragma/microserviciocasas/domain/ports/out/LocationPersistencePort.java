package com.pragma.microserviciocasas.domain.ports.out;

import com.pragma.microserviciocasas.domain.model.LocationModel;


public interface LocationPersistencePort {
    void save(LocationModel locationModel);
    LocationModel findByDepartmentAndCity(String department, String city);
}
