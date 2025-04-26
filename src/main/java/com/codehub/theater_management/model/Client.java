package com.codehub.theater_management.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;

@Entity
@Table(name = "client")
@Data //Annotation do lombok para criar os getters e setters, entre ourtas...
public class Client {

    @Id
    @Column(name = "id_client")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome",length = 255,nullable = false)
    private String nome;

    @Column(name = "email",length = 255,nullable = false)
    private String email;

    @Column(name = "cpf",nullable = false)
    private BigInteger cpf;

    @Column(name = "numero", nullable = false)
    private String numero;

}
