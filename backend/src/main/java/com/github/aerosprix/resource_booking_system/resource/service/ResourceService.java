package com.github.aerosprix.resource_booking_system.resource.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.aerosprix.resource_booking_system.resource.dto.ResourceCreateRequest;
import com.github.aerosprix.resource_booking_system.resource.dto.ResourceUpdateRequest;
import com.github.aerosprix.resource_booking_system.resource.exception.ResourceNotFoundException;
import com.github.aerosprix.resource_booking_system.resource.repository.ResourceRepository;
import com.github.aerosprix.resource_booking_system.resource.dto.ResourceResponse;
import com.github.aerosprix.resource_booking_system.resource.model.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceService {

    private final ResourceRepository resourceRepository;

    public ResourceService(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    public List<ResourceResponse> getResources() {
        List<Resource> resources = resourceRepository.findAll();

        return resources.stream()
                .map(this::convertToDto)
                .toList();
    }

    public ResourceResponse getResourceById(Long id) {
        Resource existingResource = resourceRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        return convertToDto(existingResource);
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
        // 1. Fetch the original entity
        Resource existingResource = resourceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        // 2. Perform a safe, direct structural merge
        if (resourceDto.getName().isPresent()) {
            existingResource.setName(resourceDto.getName().get());
        }

        if (resourceDto.getCategory().isPresent()) {
            existingResource.setCategory(resourceDto.getCategory().get());
        }

        if (resourceDto.getDescription().isPresent()) {
            existingResource.setDescription(resourceDto.getDescription().get());
        }

        if (resourceDto.getActive().isPresent()) {
            existingResource.setActive(resourceDto.getActive().get());
        }

        // 3. Save, convert, and return
        Resource savedResource = resourceRepository.save(existingResource);
        return convertToDto(savedResource);
    }


    public void deleteResource(Long id) {
        Resource existingResource = resourceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        resourceRepository.delete(existingResource);
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
