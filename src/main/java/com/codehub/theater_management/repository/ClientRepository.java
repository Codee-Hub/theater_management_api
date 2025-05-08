package com.codehub.theater_management.repository;

import com.codehub.theater_management.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
