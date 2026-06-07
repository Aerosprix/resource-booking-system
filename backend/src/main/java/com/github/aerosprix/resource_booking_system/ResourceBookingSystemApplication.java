package com.github.aerosprix.resource_booking_system;

import org.flywaydb.core.Flyway;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ResourceBookingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResourceBookingSystemApplication.class, args);


    }
}
