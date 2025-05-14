package com.codehub.theater_management.controller.dto;


import lombok.Data;

@Data
public class RoomAreaDTO {

    private Long id;
    private String nomeArea;
    private Integer capacity;
    private Long idRoom;


}
