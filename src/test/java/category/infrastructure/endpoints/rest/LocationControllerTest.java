package category.infrastructure.endpoints.rest;

import com.pragma.microserviciocasas.application.dto.request.SaveLocationRequest;
import com.pragma.microserviciocasas.application.dto.response.SaveLocationResponse;
import com.pragma.microserviciocasas.application.services.LocationService;
import com.pragma.microserviciocasas.infrastructure.endpoints.rest.LocationController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LocationControllerTest {

    @Mock
    private LocationService locationService;

    @InjectMocks
    private LocationController locationController;


    @Test
    void save_Successful_ReturnsCreatedStatus() {
        // Arrange
        SaveLocationRequest request = new SaveLocationRequest("Cartagena", "Bolivar", "Tourist city");
        SaveLocationResponse response = new SaveLocationResponse("Location saved", null);
        when(locationService.save(request)).thenReturn(response);

        // Act
        ResponseEntity<SaveLocationResponse> result = locationController.save(request);

        // Assert
        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        assertEquals(response, result.getBody());
        verify(locationService).save(request);
    }
}