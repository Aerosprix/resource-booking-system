package com.github.aerosprix.resource_booking_system.resource.service;

import com.github.aerosprix.resource_booking_system.resource.dto.CreateResourceRequest;
import com.github.aerosprix.resource_booking_system.resource.repository.ResourceRepository;
import com.github.aerosprix.resource_booking_system.resource.dto.ResourceResponse;
import com.github.aerosprix.resource_booking_system.resource.model.Resource;
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

    public ResourceResponse createResource(CreateResourceRequest resourceDto) {
        System.out.println(resourceDto);
        Resource resourceEntity = new Resource();
        resourceEntity.setName(resourceDto.name());
        resourceEntity.setCategory(resourceDto.category());
        resourceEntity.setDescription(resourceDto.description());
        Resource savedResource = resourceRepository.save(resourceEntity);
        return convertToDto(savedResource);
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
