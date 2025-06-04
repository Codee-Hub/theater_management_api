package com.codehub.theater_management.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@Table(name = "spectacle")
public class Spectacle {

    @Id
    @Column(name = "id_spectacle", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_time")
    private Timestamp date;

    @Column(name = "durationInMinutes")
    private Integer  durationInMinutes;

    private String nome;

    @Column(name = "preco_base")
    private Integer precoBase;

    @ManyToOne
    @JoinColumn(name = "id_room", nullable = false)
    private Room room;

    @JsonIgnore
    @OneToMany(mappedBy = "spectacle" , cascade = CascadeType.ALL, orphanRemoval = true)
    List<TicketPrice> ticketPrices =  new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "spectacle" , cascade = CascadeType.ALL, orphanRemoval = true)
    List<Ticket>  tickets = new ArrayList<>();

}
