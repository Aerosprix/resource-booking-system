package com.github.aerosprix.resource_booking_system.booking.service;

import com.github.aerosprix.resource_booking_system.booking.dto.CreateBookingRequest;
import com.github.aerosprix.resource_booking_system.booking.model.Booking;

public class BookingService {

    public Booking createBooking(CreateBookingRequest request) {
        // validate resource exists

        // validate user exists

        // validate no overlapping bookings

        // save booking

        return new Booking();
    }
}
