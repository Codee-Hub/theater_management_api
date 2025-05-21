package com.codehub.theater_management.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(name = "data_time", unique = true)
    private Timestamp date;

    @Column(name = "duration", unique = true)
    private LocalTime  duration;

    @ManyToOne
    @JoinColumn(name = "id_room", nullable = false)
    @JsonIgnore
    private Room room;

    @OneToMany(mappedBy = "spectacle" , cascade = CascadeType.ALL, orphanRemoval = true)
    List<TicketPrice> ticketPrices =  new ArrayList<>();


}
