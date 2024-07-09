package com.quevedo.api.inmobiliaria_backend.aplication.services.auth;

import com.quevedo.api.inmobiliaria_backend.domain.models.Usuario;

public interface IJwtService {
    String generateToken(Usuario usuario);
    String extractUsername(String token);
}
