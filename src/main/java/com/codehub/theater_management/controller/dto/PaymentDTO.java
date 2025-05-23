package com.codehub.theater_management.controller.dto;

import lombok.Data;

@Data
public class PaymentDTO {

    private Long id;
    private Double price;
    private Integer status;
    private Long paymentMethodId;
    private Long ticketId;


}
