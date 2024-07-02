package com.quevedo.api.inmobiliaria_backend.infraestructure.repositories.cliente;

import com.quevedo.api.inmobiliaria_backend.infraestructure.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepositoryJpa extends JpaRepository<ClienteEntity, Integer> {
}
