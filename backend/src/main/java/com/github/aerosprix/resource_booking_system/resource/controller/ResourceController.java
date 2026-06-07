package com.github.aerosprix.resource_booking_system.resource.controller;

import com.github.aerosprix.resource_booking_system.resource.dto.CreateResourceRequest;
import com.github.aerosprix.resource_booking_system.resource.service.ResourceService;
import com.github.aerosprix.resource_booking_system.resource.dto.ResourceResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<ResourceResponse> createResource(CreateResourceRequest resource) {
        ResourceResponse createdResource = resourceService.createResource(resource);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdResource);
    }
}
