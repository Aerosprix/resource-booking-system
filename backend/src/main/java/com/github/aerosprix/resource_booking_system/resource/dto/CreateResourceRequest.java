package com.github.aerosprix.resource_booking_system.resource.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateResourceRequest(
        @NotBlank(message = "Resource name is required")
        @Size(max = 100, message = "Name cannot exceed 100 characters")
        String name,

        @NotBlank(message = "Category is required")
        String category,

        @Size(max = 1000)
        String description
) {}
