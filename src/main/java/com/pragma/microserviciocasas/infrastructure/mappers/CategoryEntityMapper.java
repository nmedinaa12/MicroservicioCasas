package com.pragma.microserviciocasas.infrastructure.mappers;

import com.pragma.microserviciocasas.domain.model.CategoryModel;
import com.pragma.microserviciocasas.infrastructure.entities.CategoryEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface CategoryEntityMapper {
    CategoryEntity modelToEntity(CategoryModel categoryModel);
    CategoryModel entityToModel(CategoryEntity categoryEntity);
}
