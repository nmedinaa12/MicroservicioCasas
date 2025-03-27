package category.infrastructure.adapters.persistence;

import com.pragma.microserviciocasas.domain.model.CategoryModel;
import com.pragma.microserviciocasas.infrastructure.adapters.persistence.CategoryPersistenceAdapter;
import com.pragma.microserviciocasas.infrastructure.entities.CategoryEntity;
import com.pragma.microserviciocasas.infrastructure.mappers.CategoryEntityMapper;
import com.pragma.microserviciocasas.infrastructure.repositories.mysql.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CategoryPersistenceAdapterTest {

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private CategoryEntityMapper entityMapper;

    @InjectMocks
    private CategoryPersistenceAdapter persistenceAdapter;


    @Test
    void save_category_success() {
        // Arrange
        CategoryModel model = new CategoryModel(null, "Tech", "Tech stuff");
        CategoryEntity entity = new CategoryEntity(null, "Tech", "Tech stuff");
        when(entityMapper.modelToEntity(model)).thenReturn(entity);

        // Act
        persistenceAdapter.save(model);

        // Assert
        verify(categoryRepository).save(entity);
    }


    @Test
    void get_by_name_category_success() {
        // Act
        persistenceAdapter.getCategoryByName(Mockito.anyString());
        // Assert
        verify(categoryRepository).findByName(Mockito.anyString());
    }
}