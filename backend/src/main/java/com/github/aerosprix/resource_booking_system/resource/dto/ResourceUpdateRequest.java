package com.github.aerosprix.resource_booking_system.resource.dto;

public record ResourceUpdateRequest(
        String name,
        String category,
        String description,
        Boolean active
) {
}
