package com.codehub.theater_management.service;

import com.codehub.theater_management.model.Client;
import com.codehub.theater_management.model.enums.UserRole;
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

    public Client deletar(Client client) {
        repository.delete(client);
        return client;
    }

    public Client salvarAdmin(Client clientData) { // Supondo que clientData já tenha email, senha, etc.
        clientData.setRole(UserRole.ROLE_ADMIN);
        // ... lógica para hashear a senha antes de salvar ...
        return repository.save(clientData);
    }

    public Client salvarClienteComum(Client clientData) {
        clientData.setRole(UserRole.ROLE_CLIENT);
        // Clientes comuns podem não ter senha ou ter uma senha padrão não utilizável para login administrativo
        // Se não forem logar, o campo senha pode ser nulo ou você pode hashear uma string aleatória.
        // Considere a lógica de registro de clientes comuns.
        return repository.save(clientData);
    }

}
