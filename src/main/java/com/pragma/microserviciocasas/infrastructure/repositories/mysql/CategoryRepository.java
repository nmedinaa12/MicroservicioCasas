package com.pragma.microserviciocasas.infrastructure.repositories.mysql;

import com.pragma.microserviciocasas.infrastructure.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;


import java.util.Optional;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    Optional<CategoryEntity> findByName(String name);
    Page<CategoryEntity> findAll(Pageable pageable);
}