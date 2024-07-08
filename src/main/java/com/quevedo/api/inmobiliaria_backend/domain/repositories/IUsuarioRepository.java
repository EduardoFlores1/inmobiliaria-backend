package com.quevedo.api.inmobiliaria_backend.domain.repositories;

import com.quevedo.api.inmobiliaria_backend.domain.models.Usuario;

import java.util.Optional;

public interface IUsuarioRepository extends ICommonRepository<Usuario>{
    Optional<Usuario> buscarUsuarioEstadoTrue(int idEmpleado);
}
