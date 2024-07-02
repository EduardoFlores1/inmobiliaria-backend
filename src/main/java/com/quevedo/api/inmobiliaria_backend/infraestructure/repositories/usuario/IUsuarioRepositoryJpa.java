package com.quevedo.api.inmobiliaria_backend.infraestructure.repositories.usuario;

import com.quevedo.api.inmobiliaria_backend.infraestructure.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepositoryJpa extends JpaRepository<UsuarioEntity, Integer> {
}
