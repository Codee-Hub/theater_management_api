package com.codehub.theater_management.controller;


import com.codehub.theater_management.controller.dto.SpectacleDTO;
import com.codehub.theater_management.model.Spectacle;
import com.codehub.theater_management.repository.SpectacleRepository;
import com.codehub.theater_management.service.SpectacleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spectacles")
public class SpectacleController {

    @Autowired
    public SpectacleRepository repository;

    @Autowired
    public SpectacleService service;


    @PostMapping
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
    public ResponseEntity<List<SpectacleDTO>> listarTodos() {
        List<SpectacleDTO> spectacles = service.listar();
        return ResponseEntity.ok(spectacles);
    }

    @GetMapping("{id}")
    public Spectacle findById(@PathVariable Long id) {
        Spectacle spectacle = repository.findById(id).get();
        return spectacle;
    }

    @DeleteMapping("{id}")
    public Spectacle deletar(@PathVariable Long id) {
        Spectacle spectacle = repository.findById(id).get();
        repository.delete(spectacle);
        return spectacle;
    }


}
