package com.quevedo.api.inmobiliaria_backend.infraestructure.repositories.contrato;

import com.quevedo.api.inmobiliaria_backend.infraestructure.entities.ContratoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContratoRepositoryJpa extends JpaRepository<ContratoEntity, Integer> {
}
