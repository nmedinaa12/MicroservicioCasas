package com.pragma.microserviciocasas.infrastructure.adapters.persistence;

import com.pragma.microserviciocasas.domain.model.CategoryModel;
import com.pragma.microserviciocasas.domain.ports.out.CategoryPersistencePort;
import com.pragma.microserviciocasas.infrastructure.mappers.CategoryEntityMapper;
import com.pragma.microserviciocasas.infrastructure.repositories.mysql.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryPersistenceAdapter implements CategoryPersistencePort {
    private final CategoryRepository categoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;

    @Override
    public void save(CategoryModel categoryModel) {
        categoryRepository.save(categoryEntityMapper.modelToEntity(categoryModel));
    }

    @Override
    public CategoryModel getCategoryByName(String categoryName) {
        return categoryEntityMapper.entityToModel(categoryRepository.findByName(categoryName).orElse(null));
    }
}