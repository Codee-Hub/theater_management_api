package com.codehub.theater_management.repository;

import com.codehub.theater_management.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoomRepository extends JpaRepository<Room, Long> {
}
