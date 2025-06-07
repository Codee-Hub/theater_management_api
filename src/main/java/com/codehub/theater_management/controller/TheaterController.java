package com.codehub.theater_management.controller;

import com.codehub.theater_management.model.Theater;
import com.codehub.theater_management.repository.TheaterRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theaters")
@Tag(name = "Theater", description = "Endpoints para gerenciamento de Teatros")
public class TheaterController {

    @Autowired
    public TheaterRepository repository;

    @PostMapping
    @Operation(summary = "Criar", description = "Cria um Teatro")
    public Theater salvar(@RequestBody Theater theater){
        return repository.save(theater);
    }

    @GetMapping
    @Operation(summary = "Listar", description = "Lista todos Teatros")
    public List<Theater> listar(){
        return repository.findAll();
    }



}
