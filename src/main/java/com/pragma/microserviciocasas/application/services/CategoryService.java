package com.pragma.microserviciocasas.application.services;

import com.pragma.microserviciocasas.application.dto.request.SaveCategoryRequest;
import com.pragma.microserviciocasas.application.dto.response.SaveCategoryResponse;


public interface CategoryService {
    SaveCategoryResponse save(SaveCategoryRequest request);
}
