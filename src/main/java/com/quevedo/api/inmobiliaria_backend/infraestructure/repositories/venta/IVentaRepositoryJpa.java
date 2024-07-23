package com.quevedo.api.inmobiliaria_backend.infraestructure.repositories.venta;

import com.quevedo.api.inmobiliaria_backend.infraestructure.entities.VentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVentaRepositoryJpa extends JpaRepository<VentaEntity, Integer> {
}
