package com.github.aerosprix.resource_booking_system.resource.repository;

import com.github.aerosprix.resource_booking_system.resource.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {
}
