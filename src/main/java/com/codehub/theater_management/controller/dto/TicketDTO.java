package com.codehub.theater_management.controller.dto;

import lombok.Data;

@Data
public class TicketDTO {

    private Long id;
    private Long spectacleId;
    private Long clientId;
    private Long armchairId;
    private Long ticketPriceId;


}
