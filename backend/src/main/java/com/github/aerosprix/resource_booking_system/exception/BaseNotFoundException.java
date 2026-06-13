package com.github.aerosprix.resource_booking_system.exception;

public abstract class BaseNotFoundException extends RuntimeException {
    protected BaseNotFoundException(String message) {
        super(message);
    }
}
