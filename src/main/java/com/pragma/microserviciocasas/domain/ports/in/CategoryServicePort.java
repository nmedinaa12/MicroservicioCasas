package com.pragma.microserviciocasas.domain.ports.in;

import com.pragma.microserviciocasas.domain.model.CategoryModel;


public interface CategoryServicePort {
    void save(CategoryModel categoryModel);
}
