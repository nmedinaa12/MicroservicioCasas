package com.pragma.microserviciocasas.domain.ports.out;

import com.pragma.microserviciocasas.domain.model.CategoryModel;

import java.util.List;


public interface CategoryPersistencePort {
    void save(CategoryModel categoryModel);
    CategoryModel getCategoryByName(String categoryName);
    List<CategoryModel> getCategories(Integer page, Integer size, boolean orderAsc);
}
