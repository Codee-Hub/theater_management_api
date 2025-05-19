package com.codehub.theater_management.service;

import com.codehub.theater_management.model.Client;
import com.codehub.theater_management.model.PersonType;
import com.codehub.theater_management.repository.ClientRepository;
import com.codehub.theater_management.repository.PersonTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonTypeService {

    @Autowired
    public PersonTypeRepository repository;

    public PersonType salvar(PersonType personType) {
        return repository.save(personType);
    }

    public List<PersonType> listar(List<PersonType> persontypes) {
        return repository.findAll();
    }

    public PersonType deletar(PersonType persontype) {
        repository.delete(persontype);
        return persontype;
    }

}
