package com.github.aerosprix.resource_booking_system.resource.dto;

public record ResourceResponse(
    Long id,
    String name,
    String category,
    String description,
    Boolean active
) {}
