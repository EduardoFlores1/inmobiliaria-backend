package com.quevedo.api.inmobiliaria_backend.infraestructure.repositories.contrato;

import com.quevedo.api.inmobiliaria_backend.infraestructure.entities.ContratoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IContratoRepositoryJpa extends JpaRepository<ContratoEntity, Integer> {
    @Query(value = "SELECT TOP 1 * FROM Contratos WHERE Id_Empleado = :idEmpleado ORDER BY Id_Contrato DESC", nativeQuery = true)
    Optional<ContratoEntity> buscarPorIdEmpleado(@Param("idEmpleado") Integer idEmpleado);
}
