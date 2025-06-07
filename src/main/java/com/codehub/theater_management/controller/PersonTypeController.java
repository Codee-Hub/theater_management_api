package com.codehub.theater_management.controller;

import com.codehub.theater_management.model.PersonType;
import com.codehub.theater_management.repository.PersonTypeRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persontypes")
@Tag(name = "PersonType", description = "Endpoints para gerenciamento de Tipo Pessoa")
public class PersonTypeController {

    @Autowired
    public PersonTypeRepository repository;

    @PostMapping
    @Operation(summary = "Salvar", description = "Salva tipo pessoa")
    public PersonType salvar(@RequestBody PersonType personType) {
        return repository.save(personType);
    }

    @GetMapping
    @Operation(summary = "Listar", description = "Lista todos tipos pessoa")
    public List<PersonType> listar()    {
        return repository.findAll(); //.subList(0, 100) Postman limita usar para teste
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Deletar", description = "Deleta tipo pessoa")
    public PersonType deletar(@PathVariable Long id) {
        PersonType personType = repository.findById(id).get();
        repository.delete(personType);
        return personType;
    }



}
