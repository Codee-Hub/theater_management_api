package com.codehub.theater_management.controller.dto;

import lombok.Data;
import java.math.BigInteger;

@Data
public class ClientDTO {
    private Long id;
    private String nome;
    private String email;
    private BigInteger cpf;
    private String numero;
   
}