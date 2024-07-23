package com.quevedo.api.inmobiliaria_backend.aplication.usecases.auth.usuario;

import com.quevedo.api.inmobiliaria_backend.domain.models.Usuario;
import com.quevedo.api.inmobiliaria_backend.domain.repositories.IUsuarioRepository;
import com.quevedo.api.inmobiliaria_backend.infraestructure.mappers.UsuarioMapper;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.usuario.UsuarioDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class GetUserAuthCaseUse implements IGetUserAuthCaseUse{

    private final IUsuarioRepository usuarioRepository;

    public GetUserAuthCaseUse(IUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public UsuarioDTO execute(String username) {

        Optional<Usuario> usuario = usuarioRepository.findByUsername(username);
        if(usuario.isPresent()) {
            return UsuarioMapper.toResponse(usuario.get());
        }

        throw new EntityNotFoundException();
    }
}
