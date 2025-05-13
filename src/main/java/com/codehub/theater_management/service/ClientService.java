package com.codehub.theater_management.service;

import com.codehub.theater_management.model.Client;
import com.codehub.theater_management.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    public ClientRepository repository;

    public Client salvar(Client client) {
        return repository.save(client);
    }

    public List<Client> listar(List<Client> clients) {
        return repository.findAll();
    }

}
