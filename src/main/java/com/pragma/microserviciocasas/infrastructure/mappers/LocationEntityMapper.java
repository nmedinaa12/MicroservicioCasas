package com.pragma.microserviciocasas.infrastructure.mappers;


import com.pragma.microserviciocasas.domain.model.LocationModel;
import com.pragma.microserviciocasas.infrastructure.entities.LocationEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface LocationEntityMapper {
    LocationEntity modelToEntity(LocationModel locationModel);
    LocationModel entityToModel(LocationEntity categoryEntity);
}
