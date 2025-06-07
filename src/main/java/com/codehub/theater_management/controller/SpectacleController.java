package com.codehub.theater_management.controller;


import com.codehub.theater_management.controller.dto.SpectacleDTO;
import com.codehub.theater_management.model.Spectacle;
import com.codehub.theater_management.repository.SpectacleRepository;
import com.codehub.theater_management.service.SpectacleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spectacles")
@Tag(name = "Spectacles", description = "Endpoints para gerenciamento de Espetaculos")
public class SpectacleController {

    @Autowired
    public SpectacleRepository repository;

    @Autowired
    public SpectacleService service;


    @PostMapping
    @Operation(summary = "Criar", description = "Cria um espetáculo")
    public ResponseEntity<SpectacleDTO> salvar(@RequestBody SpectacleDTO  spectacleDTO) {
        try {
            SpectacleDTO salvo = service.salvar(spectacleDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
        }  catch (RuntimeException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping
    @Operation(summary = "Listar", description = "Lista todos espetáculo")
    public ResponseEntity<List<SpectacleDTO>> listarTodos() {
        List<SpectacleDTO> spectacles = service.listar();
        return ResponseEntity.ok(spectacles);
    }

    @GetMapping("{id}")
    @Operation(summary = "Buscar", description = "Busca espetáculos por id")
    public Spectacle findById(@PathVariable Long id) {
        Spectacle spectacle = repository.findById(id).get();
        return spectacle;
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Deletar", description = "Deleta um espetáculo")
    public Spectacle deletar(@PathVariable Long id) {
        Spectacle spectacle = repository.findById(id).get();
        repository.delete(spectacle);
        return spectacle;
    }


}
