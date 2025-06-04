package com.codehub.theater_management.model;

import com.codehub.theater_management.model.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

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

    private String senha;

    private String role; // valores: "ADMIN" ou "USER"

    @JsonIgnore
    @OneToMany(mappedBy = "client" , cascade = CascadeType.ALL, orphanRemoval = true)
    List<Ticket> tickets = new ArrayList<>();


}
