package com.pragma.microserviciocasas.infrastructure.endpoints.rest;

import com.pragma.microserviciocasas.application.dto.request.SaveLocationRequest;
import com.pragma.microserviciocasas.application.dto.response.SaveLocationResponse;
import com.pragma.microserviciocasas.application.services.LocationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/location")
@RequiredArgsConstructor
@Tag(name = "Locations", description = "Create and search locations")
public class LocationController {

    private final LocationService locationService;

    @PostMapping("/")
    @Operation(
            summary = "Create Location",
            description = "Create a location with city, department, and description",
            tags = {"Create Locations"},
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Requires a JSON with city, department, and description",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = SaveLocationRequest.class)
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Location created",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = SaveLocationResponse.class)
                            )
                    )
            }
    )
    public ResponseEntity<SaveLocationResponse> save(@RequestBody SaveLocationRequest saveLocationRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(locationService.save(saveLocationRequest));
    }
}
