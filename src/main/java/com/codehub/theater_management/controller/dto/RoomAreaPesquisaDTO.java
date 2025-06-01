package com.codehub.theater_management.controller.dto;

import com.codehub.theater_management.model.Room;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "RoomAreaPesquisa")
public class RoomAreaPesquisaDTO {


    private Long id;
    private String nomeArea;
    private Integer capacity;
    private Room idRoom;


}
