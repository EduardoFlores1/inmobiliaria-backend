package com.quevedo.api.inmobiliaria_backend.infraestructure.repositories.empleado;

import com.quevedo.api.inmobiliaria_backend.infraestructure.entities.EmpleadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmpleadoRepositoryJpa extends JpaRepository<EmpleadoEntity, Integer> {
}
