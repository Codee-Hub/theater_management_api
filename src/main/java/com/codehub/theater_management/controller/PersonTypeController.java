package com.codehub.theater_management.controller;

import com.codehub.theater_management.model.PersonType;
import com.codehub.theater_management.repository.PersonTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persontypes")
public class PersonTypeController {

    @Autowired
    public PersonTypeRepository repository;

    @PostMapping
    public PersonType salvar(@RequestBody PersonType personType) {
        return repository.save(personType);
    }

    @GetMapping
    public List<PersonType> listar() {
        return repository.findAll(); //.subList(0, 100) Postman limita usar para teste
    }

    @DeleteMapping("{id}")
    public PersonType deletar(@PathVariable Long id) {
        PersonType personType = repository.findById(id).get();
        repository.delete(personType);
        return personType;
    }



}
