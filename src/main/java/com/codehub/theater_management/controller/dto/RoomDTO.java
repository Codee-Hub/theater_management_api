package com.codehub.theater_management.controller.dto;

import lombok.Data;

@Data
public class RoomDTO {

    private Long id;
    private Integer roomNumber;
    private Integer capacity;
    private Long idTheater;



}
