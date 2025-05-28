package com.codehub.theater_management.model;

import com.codehub.theater_management.model.enums.UserRole;
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

    @OneToMany(mappedBy = "client" , cascade = CascadeType.ALL, orphanRemoval = true)
    List<Ticket> tickets = new ArrayList<>();

    // --- CAMPOS ADICIONADOS/MODIFICADOS PARA SPRING SECURITY COM ENUM ---
    @Column(name = "password")
    private String password; // Senha hasheada. Não nula para quem pode logar.

    @Column(name = "enabled")
    private boolean enabled = true;

    @Enumerated(EnumType.STRING) // Persiste o Enum como String (ex: "ROLE_ADMIN")
    @Column(name = "role", nullable = false)
    private UserRole role; // Armazena o cargo do cliente
    // --- FIM DOS CAMPOS ADICIONADOS/MODIFICADOS ---

    // Construtor padrão e outros getters/setters são gerenciados pelo @Data do Lombok

}
