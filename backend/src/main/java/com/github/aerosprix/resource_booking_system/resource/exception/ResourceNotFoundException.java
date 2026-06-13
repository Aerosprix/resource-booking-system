package com.github.aerosprix.resource_booking_system.resource.exception;

import com.github.aerosprix.resource_booking_system.exception.BaseNotFoundException;

public class ResourceNotFoundException extends BaseNotFoundException {
    public ResourceNotFoundException(Long id) {
        super("Resource not found with id: " + id);
    }
}
