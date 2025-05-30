package com.codehub.theater_management.service;

import com.codehub.theater_management.model.Client;
import com.codehub.theater_management.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private ClientRepository clientRepository; // Seu repositório de Client

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Client client = clientRepository.findByEmail(email) // Busca o cliente pelo email
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado com o email: " + email));

        if (client.getPassword() == null || client.getPassword().isEmpty()) {
            throw new UsernameNotFoundException("Usuário não possui senha configurada para login: " + email);
        }
        if (client.getRole() == null) {
            throw new UsernameNotFoundException("Usuário não possui cargo definido: " + email);
        }

        Set<GrantedAuthority> authorities = new HashSet<>();
        // O nome do Enum (UserRole.ROLE_ADMIN.name()) já é "ROLE_ADMIN"
        authorities.add(new SimpleGrantedAuthority(client.getRole().name()));

        return new User(
                client.getEmail(), // Username (email neste caso)
                client.getPassword(), // Senha (já hasheada no banco)
                client.isEnabled(), // enabled
                true, // accountNonExpired
                true, // credentialsNonExpired
                true, // accountNonLocked
                authorities // Cargos (roles)
        );
    }
}