package com.codehub.theater_management.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "theater")
@Data
public class Theater {

    @Id
    @Column(name = "id_theater")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "address", nullable = false)
    private String address;





}
