package com.powerfuel.powerfuelapi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                // REGLA RF-35: Solo los ADMIN pueden crear (POST) o borrar (DELETE) productos
               // .requestMatchers(HttpMethod.POST, "/api/productos").hasRole("ADMIN")
               // .requestMatchers(HttpMethod.DELETE, "/api/productos/**").hasRole("ADMIN")
                
                // Permitimos que todos vean los productos (GET) y usen el resto de la app para pruebas
                .anyRequest().permitAll()
            );
        
        return http.build();
    }
}