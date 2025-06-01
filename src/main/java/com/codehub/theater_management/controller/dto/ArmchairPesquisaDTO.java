package com.codehub.theater_management.controller.dto;

import com.codehub.theater_management.model.RoomArea;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(name = "ArmchairPesquisa")
public record ArmchairPesquisaDTO(

        Long id,
        Integer numero,
        RoomArea idRoomArea

    ) {
}
