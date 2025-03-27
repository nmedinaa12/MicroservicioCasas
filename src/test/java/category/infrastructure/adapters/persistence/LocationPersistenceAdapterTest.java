package category.infrastructure.adapters.persistence;

import com.pragma.microserviciocasas.domain.model.LocationModel;
import com.pragma.microserviciocasas.infrastructure.adapters.persistence.LocationPersistenceAdapter;
import com.pragma.microserviciocasas.infrastructure.entities.LocationEntity;
import com.pragma.microserviciocasas.infrastructure.mappers.LocationEntityMapper;
import com.pragma.microserviciocasas.infrastructure.repositories.mysql.LocationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LocationPersistenceAdapterTest {

    @Mock
    private LocationRepository locationRepository;

    @Mock
    private LocationEntityMapper locationEntityMapper;

    @InjectMocks
    private LocationPersistenceAdapter adapter;


    @Test
    void save_Success() {
        // Arrange
        LocationModel model = new LocationModel(null, "Barranquilla", "Atlantico", "Coastal city");
        LocationEntity entity = new LocationEntity(null, "Barranquilla", "Atlantico", "Coastal city");
        when(locationEntityMapper.modelToEntity(model)).thenReturn(entity);

        // Act
        adapter.save(model);

        // Assert
        verify(locationRepository).save(entity);
    }

    @Test
    void findByDepartmentAndCity_Found_ReturnsModel() {
        // Arrange
        LocationEntity entity = new LocationEntity(1L, "Barranquilla", "Atlantico", "Coastal city");
        LocationModel model = new LocationModel(1L, "Barranquilla", "Atlantico", "Coastal city");
        when(locationRepository.findByDepartmentAndCity("Atlantico", "Barranquilla"))
                .thenReturn(Optional.of(entity));
        when(locationEntityMapper.entityToModel(entity)).thenReturn(model);

        // Act
        LocationModel result = adapter.findByDepartmentAndCity("Atlantico", "Barranquilla");

        // Assert
        assertNotNull(result);
        assertEquals(model, result);
    }

    @Test
    void findByDepartmentAndCity_NotFound_ReturnsNull() {
        // Arrange
        when(locationRepository.findByDepartmentAndCity("Atlantico", "Barranquilla"))
                .thenReturn(Optional.empty());

        // Act
        LocationModel result = adapter.findByDepartmentAndCity("Atlantico", "Barranquilla");

        // Assert
        assertNull(result);
    }
}