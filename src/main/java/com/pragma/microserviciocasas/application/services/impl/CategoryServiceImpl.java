package com.pragma.microserviciocasas.application.services.impl;

import com.pragma.microserviciocasas.application.dto.request.SaveCategoryRequest;
import com.pragma.microserviciocasas.application.dto.response.CategoryResponse;
import com.pragma.microserviciocasas.application.dto.response.SaveCategoryResponse;
import com.pragma.microserviciocasas.application.mappers.CategoryDtoMapper;
import com.pragma.microserviciocasas.application.services.CategoryService;
import com.pragma.microserviciocasas.domain.ports.in.CategoryServicePort;
import com.pragma.microserviciocasas.configurations.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryServicePort categoryServicePort;
    private final CategoryDtoMapper categoryDtoMapper;

    @Override
    public SaveCategoryResponse save(SaveCategoryRequest request) {
        categoryServicePort.save(categoryDtoMapper.requestToModel(request));
        return new SaveCategoryResponse(Constants.SAVE_CATEGORY_RESPONSE_MESSAGE, LocalDateTime.now());
    }

    @Override
    public List<CategoryResponse> getCategories(Integer page, Integer size, boolean orderAsc) {
        return categoryDtoMapper.modelListToResponseList(categoryServicePort.getCategories(page, size, orderAsc));
    }
}
