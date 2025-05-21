package com.codehub.theater_management.controller.dto;

import lombok.Data;

@Data
public class TicketPriceDTO {

    private Long id;
    private Double price;
    private Long idPersonType;
    private Long idSpectacle;

}
