package com.codehub.theater_management.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "armchair")
@Data
public class Armchair {

    @Id
    @Column(name = "id_armchair",  nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero", nullable = false)
    private Integer numero;

    @ManyToOne
    @JoinColumn(name = "id_room_area", nullable = false)
    @JsonIgnore
    private RoomArea roomArea;

    @OneToMany(mappedBy = "armchair" , cascade = CascadeType.ALL, orphanRemoval = true)
    List<Ticket>  tickets = new ArrayList<>();

}
