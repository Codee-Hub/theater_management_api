package com.codehub.theater_management.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ticket")
@Data
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_spectacle", nullable = false)
    @JsonIgnore
    private Spectacle spectacle;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_client", nullable = false)
    private Client client;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_armchair", nullable = false)
    private Armchair armchair;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ticket_price", nullable = false)
    private TicketPrice ticketPrice;

    @JsonIgnore
    @OneToMany(mappedBy = "ticket" , cascade = CascadeType.ALL, orphanRemoval = true)
    List<Payment>  payments =  new ArrayList<>();

}
