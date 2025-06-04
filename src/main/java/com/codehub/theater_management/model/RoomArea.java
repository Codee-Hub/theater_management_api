package com.codehub.theater_management.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "room_area")
public class RoomArea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_area", nullable = false)
    private String nomeArea;

    @Column(name = "capacity", nullable = false)
    private Integer capacity;

    @ManyToOne
    @JoinColumn(name = "id_room", nullable = false)
    @JsonIgnore
    private Room room;

    @JsonIgnore
    @OneToMany(mappedBy = "roomArea", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Armchair> armchairs = new ArrayList<>();

    public RoomArea(Room room) {
        this.room = room;
    }

    public RoomArea() {

    }
}
