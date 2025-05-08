package com.codehub.theater_management.repository;

import com.codehub.theater_management.model.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<Theater, Long> {
}
