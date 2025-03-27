package com.pragma.microserviciocasas.domain.ports.in;

import com.pragma.microserviciocasas.domain.model.LocationModel;


public interface LocationServicePort {
    void save(LocationModel locationModel);
}