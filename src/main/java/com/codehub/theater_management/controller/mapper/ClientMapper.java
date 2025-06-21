package com.codehub.theater_management.controller.mapper;

import com.codehub.theater_management.controller.dto.ClientDTO;
import com.codehub.theater_management.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    default ClientDTO toDTO(Client client) {
        ClientDTO dto = new ClientDTO();
        dto.setId(client.getId());
        dto.setEmail(client.getEmail());
        dto.setCpf(client.getCpf());
        dto.setNumero(client.getNumero());
        dto.setNome(client.getNome());
        return dto;
    }

    @Mapping(target = "client", ignore = true)
    default Client toEntity(ClientDTO dto) {
        return null;
    }






}