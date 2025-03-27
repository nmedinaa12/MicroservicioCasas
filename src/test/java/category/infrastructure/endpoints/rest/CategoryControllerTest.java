package category.infrastructure.endpoints.rest;

import com.pragma.microserviciocasas.application.dto.request.SaveCategoryRequest;
import com.pragma.microserviciocasas.application.dto.response.SaveCategoryResponse;
import com.pragma.microserviciocasas.application.services.CategoryService;
import com.pragma.microserviciocasas.infrastructure.endpoints.rest.CategoryController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CategoryControllerTest {

    @Mock
    private CategoryService categoryService;

    @InjectMocks
    private CategoryController categoryController;

    @Test
    void shouldCreateCategorySuccessfully() {
        // Arrange
        SaveCategoryRequest request = new SaveCategoryRequest("Test Name", "Test Description");
        SaveCategoryResponse expectedResponse = new SaveCategoryResponse("Success", LocalDateTime.now());

        when(categoryService.save(request)).thenReturn(expectedResponse);

        // Act
        ResponseEntity<SaveCategoryResponse> response = categoryController.save(request);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(expectedResponse, response.getBody());
        verify(categoryService).save(request);
    }
}