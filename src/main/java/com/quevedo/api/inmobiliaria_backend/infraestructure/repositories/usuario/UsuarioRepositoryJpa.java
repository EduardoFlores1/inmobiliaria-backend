package com.quevedo.api.inmobiliaria_backend.infraestructure.repositories.usuario;

import com.quevedo.api.inmobiliaria_backend.domain.models.Usuario;
import com.quevedo.api.inmobiliaria_backend.domain.repositories.IUsuarioRepository;
import com.quevedo.api.inmobiliaria_backend.infraestructure.entities.UsuarioEntity;
import com.quevedo.api.inmobiliaria_backend.infraestructure.mappers.UsuarioMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepositoryJpa implements IUsuarioRepository {

    private final IUsuarioRepositoryJpa usuarioRepositoryJpa;

    public UsuarioRepositoryJpa(IUsuarioRepositoryJpa usuarioRepositoryJpa) {
        this.usuarioRepositoryJpa = usuarioRepositoryJpa;
    }

    @Override
    public List<Usuario> readAll() {
        return usuarioRepositoryJpa.findAll().stream()
                .map(UsuarioMapper::fromEntity).toList();
    }

    @Override
    public Optional<Usuario> readById(Integer id) {
        return usuarioRepositoryJpa.findById(id).map(UsuarioMapper::fromEntity);
    }

    @Override
    public Usuario save(Usuario usuario) {
        UsuarioEntity entity = UsuarioMapper.toEntity(usuario);
        return UsuarioMapper.fromEntity(usuarioRepositoryJpa.save(entity));
    }

    @Override
    public void delete(int id) {
        usuarioRepositoryJpa.deleteById(id);
    }

    @Override
    public Optional<Usuario> buscarUsuarioEstadoTrue(int idEmpleado) {
        return usuarioRepositoryJpa.buscarUsuarioEstadoTrue(idEmpleado)
                .map(UsuarioMapper::fromEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Usuario> findByUsername(String username) {
        return usuarioRepositoryJpa.findByUsername(username)
                .map(UsuarioMapper::fromEntity);
    }
}
