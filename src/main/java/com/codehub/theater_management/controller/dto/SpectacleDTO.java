package com.codehub.theater_management.controller.dto;


import com.codehub.theater_management.model.Spectacle;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalTime;


@Data
public class SpectacleDTO {

    private Long id;
    private Timestamp date;
    private Integer durationInMinutes;
    private String nome;
    private Long idRoom;
    private Integer precoBase;

    public SpectacleDTO() {

    }

    public SpectacleDTO(Spectacle spectacle) {
        this.id = spectacle.getId();
        this.date = spectacle.getDate();
        this.nome = spectacle.getNome();
        this.durationInMinutes = spectacle.getDurationInMinutes();
        this.precoBase = spectacle.getPrecoBase();
        if (spectacle.getRoom() != null) {
            this.idRoom = spectacle.getRoom().getId();
        }
    }
}
