package com.codehub.theater_management.controller.dto;


import com.codehub.theater_management.model.Spectacle;
import lombok.Data;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;


@Data
public class SpectacleDTO {

    private Long id;
    private Timestamp date;
    private LocalTime duration;
    private Long idRoom;


    public SpectacleDTO() {

    }

    public SpectacleDTO(Spectacle spectacle) {
        this.id = spectacle.getId();
        this.date = spectacle.getDate();
        this.duration = spectacle.getDuration();
        if (spectacle.getRoom() != null) {
            this.idRoom = spectacle.getRoom().getId();
        }
    }
}
