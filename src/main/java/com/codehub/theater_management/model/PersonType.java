package com.codehub.theater_management.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "person_type")
@Data
public class PersonType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type_name", length = 50, nullable = false)
    private String typeName;


}
