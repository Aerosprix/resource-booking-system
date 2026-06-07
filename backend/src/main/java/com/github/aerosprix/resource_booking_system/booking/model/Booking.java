package com.github.aerosprix.resource_booking_system.booking.model;

import com.github.aerosprix.resource_booking_system.booking.enums.BookingStatus;
import com.github.aerosprix.resource_booking_system.resource.model.Resource;
import com.github.aerosprix.resource_booking_system.user.model.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "resource_id")
    private Resource resource;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;
}
