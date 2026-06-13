package com.github.aerosprix.resource_booking_system.resource.controller;

import com.github.aerosprix.resource_booking_system.resource.dto.ResourceCreateRequest;
import com.github.aerosprix.resource_booking_system.resource.dto.ResourceUpdateRequest;
import com.github.aerosprix.resource_booking_system.resource.service.ResourceService;
import com.github.aerosprix.resource_booking_system.resource.dto.ResourceResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/resources")
public class ResourceController {

    private final ResourceService resourceService;

    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @GetMapping
    public List<ResourceResponse> getResources() {
        return resourceService.getResources();
    }

    @PostMapping
    public ResponseEntity<ResourceResponse> createResource(@Valid @RequestBody ResourceCreateRequest resource) {
        ResourceResponse createdResource = resourceService.createResource(resource);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdResource);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResourceResponse> updateResource(
            @Valid @PathVariable Long id,
            @Valid @RequestBody ResourceUpdateRequest resource) {
        return ResponseEntity
                .ok()
                .body(resourceService.updateResource(id, resource));
    }
}
