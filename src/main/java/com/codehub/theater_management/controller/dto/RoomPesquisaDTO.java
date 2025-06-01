package com.codehub.theater_management.controller.dto;

import com.codehub.theater_management.model.Theater;
import lombok.Data;

@Data
public class RoomPesquisaDTO {

    private Long id;
    private Integer roomNumber;
    private Integer capacity;
    private Theater idTheater;


}
