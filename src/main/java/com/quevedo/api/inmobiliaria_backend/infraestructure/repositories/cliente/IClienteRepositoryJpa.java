package com.quevedo.api.inmobiliaria_backend.infraestructure.repositories.cliente;

import com.quevedo.api.inmobiliaria_backend.infraestructure.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IClienteRepositoryJpa extends JpaRepository<ClienteEntity, Integer> {
    List<ClienteEntity> findAllByEstado(boolean estado);
}
