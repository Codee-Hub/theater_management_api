package com.codehub.theater_management.controller;

import com.codehub.theater_management.model.Theater;
import com.codehub.theater_management.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theaters")
public class TheaterController {

    @Autowired
    public TheaterRepository repository;

    @PostMapping
    public Theater salvar(@RequestBody Theater theater){
        return repository.save(theater);
    }

    @GetMapping
    public List<Theater> listar(){
        return repository.findAll();
    }



}
