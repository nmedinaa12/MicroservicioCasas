package com.pragma.microserviciocasas.domain.ports.out;

import com.pragma.microserviciocasas.domain.model.CategoryModel;


public interface CategoryPersistencePort {
    void save(CategoryModel categoryModel);
    CategoryModel getCategoryByName(String categoryName);
}
