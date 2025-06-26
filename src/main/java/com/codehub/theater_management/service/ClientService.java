package com.codehub.theater_management.service;

import com.codehub.theater_management.controller.dto.ClientDTO;
import com.codehub.theater_management.controller.dto.RoomDTO;
import com.codehub.theater_management.controller.mapper.ClientMapper;
import com.codehub.theater_management.model.Client;
import com.codehub.theater_management.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    public ClientRepository repository;
    @Autowired
    public ClientMapper mapper;

    public Client salvar(Client client) {
        return repository.save(client);
    }

    public List<ClientDTO> listar(Pageable pageable) {
        return repository.findAll(pageable)
                .map(mapper::toDTO)
                .getContent();
    }

    public Client deletar(Client client) {
        repository.delete(client);
        return client;
    }

}