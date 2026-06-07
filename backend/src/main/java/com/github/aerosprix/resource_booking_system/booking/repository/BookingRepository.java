package com.github.aerosprix.resource_booking_system.booking.repository;

import com.github.aerosprix.resource_booking_system.booking.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
