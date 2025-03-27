package category.domain.usecases;

import com.pragma.microserviciocasas.domain.exceptions.CategoryAlreadyExistsException;
import com.pragma.microserviciocasas.domain.model.CategoryModel;
import com.pragma.microserviciocasas.domain.ports.out.CategoryPersistencePort;
import com.pragma.microserviciocasas.domain.usecases.CategoryUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CategoryUseCaseTest {

    @Mock
    private CategoryPersistencePort categoryPersistencePort;

    @InjectMocks
    private CategoryUseCase categoryUseCase;

    @Test
    void shouldSaveNewCategorySuccessfully() {
        // Arrange
        CategoryModel model = new CategoryModel(null, "New Category", "Description");
        when(categoryPersistencePort.getCategoryByName(model.getName())).thenReturn(null);

        // Act
        categoryUseCase.save(model);

        // Assert
        verify(categoryPersistencePort).getCategoryByName(model.getName());
        verify(categoryPersistencePort).save(model);
    }

    @Test
    void shouldThrowExceptionWhenCategoryExists() {
        // Arrange
        CategoryModel existingModel = new CategoryModel(1L, "Existing Category", "Description");
        CategoryModel newModel = new CategoryModel(null, "Existing Category", "New Description");

        when(categoryPersistencePort.getCategoryByName(newModel.getName()))
                .thenReturn(existingModel);

        // Act & Assert
        assertThrows(CategoryAlreadyExistsException.class, () ->
                categoryUseCase.save(newModel));

        verify(categoryPersistencePort).getCategoryByName(newModel.getName());
        verify(categoryPersistencePort, never()).save(any());
    }
}