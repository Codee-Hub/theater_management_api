package com.codehub.theater_management.repository;

import com.codehub.theater_management.model.Room;
import com.codehub.theater_management.model.RoomArea;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoomAreaRepository extends JpaRepository<RoomArea, Long> {
}
