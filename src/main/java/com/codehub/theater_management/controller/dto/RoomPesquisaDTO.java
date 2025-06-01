package com.codehub.theater_management.controller.dto;

import com.codehub.theater_management.model.Theater;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "RoomPesquisa")
public record RoomPesquisaDTO(

        Long id,
        Integer roomNumber,
        Integer capacity,
        Theater idTheater
    ){
}
