package com.codehub.theater_management.service;

import com.codehub.theater_management.model.Theater;
import com.codehub.theater_management.repository.TheaterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheaterService {

    public TheaterRepository repository;

    public Theater salvar(Theater theater) {
        return repository.save(theater);
    }

    public List<Theater> listar(){
        return repository.findAll();
    }


}
