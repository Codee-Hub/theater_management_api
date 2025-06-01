package com.codehub.theater_management.controller.dto;


import com.codehub.theater_management.model.Room;
import io.swagger.v3.oas.annotations.media.Schema;

import java.sql.Timestamp;
import java.time.LocalTime;


@Schema(name = "SpectaclePesquisa")
public record SpectaclePesquisaDTO (

        Long id,
        Timestamp date,
        LocalTime duration,
        String nome,
        Room idRoom
    ){
}
