package com.codehub.theater_management.controller.dto;

import com.codehub.theater_management.model.Room;
import lombok.Data;

@Data
public class RoomAreaDTO {

    private Long id;
    private String nomeArea;
    private Integer capacity;
    private Long idRoom;


}
