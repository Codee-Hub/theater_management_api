package com.codehub.theater_management.controller.dto;

import com.codehub.theater_management.model.Room;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "RoomAreaPesquisa")
public record RoomAreaPesquisaDTO(
        Long id,
        String nomeArea,
        Integer capacity,
        Room idRoom

    ){
}
