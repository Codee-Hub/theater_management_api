package com.codehub.theater_management.repository;

import com.codehub.theater_management.model.Armchair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ArmchairRepository extends JpaRepository<Armchair, Long> {

    @Query("SELECT a FROM Armchair a WHERE a.roomArea.room.id = :roomId")
    List<Armchair> findAllByRoomId(@Param("roomId") Long roomId);
}
