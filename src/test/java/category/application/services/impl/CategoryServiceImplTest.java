package category.application.services.impl;

import com.pragma.microserviciocasas.application.dto.request.SaveCategoryRequest;
import com.pragma.microserviciocasas.application.dto.response.SaveCategoryResponse;
import com.pragma.microserviciocasas.application.mappers.CategoryDtoMapper;
import com.pragma.microserviciocasas.application.services.impl.CategoryServiceImpl;
import com.pragma.microserviciocasas.configurations.utils.Constants;
import com.pragma.microserviciocasas.domain.model.CategoryModel;
import com.pragma.microserviciocasas.domain.ports.in.CategoryServicePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CategoryServiceImplTest {

    @Mock
    private CategoryServicePort categoryServicePort;

    @Mock
    private CategoryDtoMapper categoryDtoMapper;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    @Test
    void shouldSaveCategorySuccessfully() {
        // Arrange
        SaveCategoryRequest request = new SaveCategoryRequest("Test Name", "Test Description");
        CategoryModel model = new CategoryModel(null, "Test Name", "Test Description");

        when(categoryDtoMapper.requestToModel(request)).thenReturn(model);

        // Act
        SaveCategoryResponse response = categoryService.save(request);

        // Assert
        verify(categoryDtoMapper).requestToModel(request);
        verify(categoryServicePort).save(model);

        assertEquals(Constants.SAVE_CATEGORY_RESPONSE_MESSAGE, response.message());
        assertNotNull(response.time());
    }
}