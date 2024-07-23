package com.quevedo.api.inmobiliaria_backend.infraestructure.repositories.usuario;

import com.quevedo.api.inmobiliaria_backend.infraestructure.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IUsuarioRepositoryJpa extends JpaRepository<UsuarioEntity, Integer> {
    @Query(value = "SELECT * FROM Usuarios WHERE Id_Empleado = :idEmpleado AND Estado = 1", nativeQuery = true)
    Optional<UsuarioEntity> buscarUsuarioEstadoTrue(int idEmpleado);
    Optional<UsuarioEntity> findByUsername(String username);
}
