package com.codehub.theater_management.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ticket_price")
@Data
public class TicketPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_spectacle")
    private Spectacle spectacle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_person_type")
    private PersonType personType;




}
