package com.github.aerosprix.resource_booking_system.resource.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.aerosprix.resource_booking_system.resource.dto.ResourceCreateRequest;
import com.github.aerosprix.resource_booking_system.resource.dto.ResourceUpdateRequest;
import com.github.aerosprix.resource_booking_system.resource.exception.ResourceNotFoundException;
import com.github.aerosprix.resource_booking_system.resource.repository.ResourceRepository;
import com.github.aerosprix.resource_booking_system.resource.dto.ResourceResponse;
import com.github.aerosprix.resource_booking_system.resource.model.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResourceService {

    private final ResourceRepository resourceRepository;
    private final ObjectMapper objectMapper;

    public ResourceService(ResourceRepository resourceRepository, ObjectMapper objectMapper) {
        this.resourceRepository = resourceRepository;
        this.objectMapper = objectMapper;
    }

    public List<ResourceResponse> getResources() {
        List<Resource> resources = resourceRepository.findAll();

        return resources.stream()
                .map(this::convertToDto)
                .toList();
    }

    public ResourceResponse createResource(ResourceCreateRequest resourceDto) {
        Resource resourceEntity = new Resource();
        resourceEntity.setName(resourceDto.name());
        resourceEntity.setCategory(resourceDto.category());
        resourceEntity.setDescription(resourceDto.description());
        Resource savedResource = resourceRepository.save(resourceEntity);
        return convertToDto(savedResource);
    }

    public ResourceResponse updateResource(Long id, ResourceUpdateRequest resourceDto) {
        Resource existingResource = resourceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        try {
            objectMapper.readerForUpdating(existingResource).readValue(objectMapper.writeValueAsString(resourceDto));
        } catch (Exception e) {
            throw new RuntimeException("Failed to patch resource details", e);
        }

        return convertToDto(
                resourceRepository.save(existingResource));
    }

    private ResourceResponse convertToDto(Resource resource) {
        return new ResourceResponse(
                resource.getId(),
                resource.getName(),
                resource.getCategory(),
                resource.getDescription(),
                resource.getActive()
        );
    }

}
