package com.pragma.microserviciocasas.configurations.beans;

import com.pragma.microserviciocasas.domain.ports.in.CategoryServicePort;
import com.pragma.microserviciocasas.domain.ports.in.LocationServicePort;
import com.pragma.microserviciocasas.domain.ports.out.CategoryPersistencePort;
import com.pragma.microserviciocasas.domain.ports.out.LocationPersistencePort;
import com.pragma.microserviciocasas.domain.usecases.CategoryUseCase;
import com.pragma.microserviciocasas.domain.usecases.LocationUseCase;
import com.pragma.microserviciocasas.infrastructure.adapters.persistence.CategoryPersistenceAdapter;
import com.pragma.microserviciocasas.infrastructure.adapters.persistence.LocationPersistenceAdapter;
import com.pragma.microserviciocasas.infrastructure.mappers.CategoryEntityMapper;
import com.pragma.microserviciocasas.infrastructure.mappers.LocationEntityMapper;
import com.pragma.microserviciocasas.infrastructure.repositories.mysql.CategoryRepository;
import com.pragma.microserviciocasas.infrastructure.repositories.mysql.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final CategoryRepository categoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;
    private final LocationRepository locationRepository;
    private final LocationEntityMapper locationEntityMapper;

    @Bean
    public CategoryServicePort categoryServicePort() {
        return new CategoryUseCase(categoryPersistencePort());
    }

    @Bean
    public CategoryPersistencePort categoryPersistencePort() {
        return new CategoryPersistenceAdapter(categoryRepository, categoryEntityMapper);
    }
    @Bean
    public LocationServicePort locationServicePort() {
        return new LocationUseCase(locationPersistencePort());
    }

    @Bean
    public LocationPersistencePort locationPersistencePort() {
        return new LocationPersistenceAdapter(locationRepository, locationEntityMapper);
    }
}
