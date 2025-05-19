package com.codehub.theater_management.repository;

import com.codehub.theater_management.model.PersonType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonTypeRepository extends JpaRepository<PersonType, Long> {
}
