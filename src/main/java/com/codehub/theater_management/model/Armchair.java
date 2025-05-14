package com.codehub.theater_management.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "armchair")
@Data
public class Armchair {

    @Id
    @Column(name = "id_armchair")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero")
    private Integer numero;

    @ManyToOne
    @JoinColumn(name = "id_room_area", nullable = false)
    @JsonIgnore
    private RoomArea roomArea;

}
