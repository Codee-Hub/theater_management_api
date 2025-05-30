package com.codehub.theater_management.conig;

import com.codehub.theater_management.model.enums.UserRole;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, UserDetailsService userDetailsService) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Desabilitar CSRF para APIs REST stateless
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // API Stateless
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.POST, "/spectacles").hasRole(UserRole.ROLE_ADMIN.name().replace("ROLE_", "")) // Apenas ADMIN pode criar espetáculos
                        // Adicione aqui outras regras de autorização para outros endpoints
                        // Exemplo: permitir que todos listem espetáculos
                        .requestMatchers(HttpMethod.GET, "/spectacles").permitAll()
                        // Exemplo: endpoints de cliente podem ser acessados por ROLE_CLIENT ou ROLE_ADMIN
                        .requestMatchers("/clients/**").hasAnyRole(UserRole.ROLE_CLIENT.name().replace("ROLE_", ""), UserRole.ROLE_ADMIN.name().replace("ROLE_", ""))
                        // Para outros endpoints, você pode exigir autenticação geral ou permitir acesso
                        .anyRequest().authenticated() // Por padrão, todas as outras requisições exigem autenticação
                )
                .userDetailsService(userDetailsService) // Define o seu UserDetailsService customizado
                .httpBasic(Customizer.withDefaults()); // Habilita HTTP Basic Authentication (para começar)

        return http.build();


    }
}