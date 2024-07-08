package com.quevedo.api.inmobiliaria_backend.aplication.usecases.usuario.update;

import com.quevedo.api.inmobiliaria_backend.domain.models.Usuario;
import com.quevedo.api.inmobiliaria_backend.domain.repositories.IUsuarioRepository;
import com.quevedo.api.inmobiliaria_backend.infraestructure.mappers.UsuarioMapper;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.usuario.UsuarioDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UsuarioUpdateUseCase implements IUsuarioUpdateUseCase{

    private final IUsuarioRepository usuarioRepository;

    public UsuarioUpdateUseCase(IUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    @Transactional
    public UsuarioDTO execute(int id, UsuarioDTO usuarioDTO) {
        // if usuario exist
        Optional<Usuario> opt = usuarioRepository.readById(id);
        if (opt.isPresent()) {
            usuarioDTO.setIdUsuario(id);
            try {
                Usuario usuarioUpdate = usuarioRepository.save(
                        UsuarioMapper.fromDtoToUsuario(usuarioDTO)
                );
                return UsuarioMapper.toResponse(usuarioUpdate);
            }catch (Exception e) {
                throw new RuntimeException("Error al actualizar usuario", e);
            }

        }else {
            throw new RuntimeException("El id de usuario no existe");
        }
    }
}
