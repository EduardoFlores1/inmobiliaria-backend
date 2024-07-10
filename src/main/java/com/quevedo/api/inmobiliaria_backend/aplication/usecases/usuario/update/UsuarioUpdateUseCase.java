package com.quevedo.api.inmobiliaria_backend.aplication.usecases.usuario.update;

import com.quevedo.api.inmobiliaria_backend.domain.models.Usuario;
import com.quevedo.api.inmobiliaria_backend.domain.repositories.IUsuarioRepository;
import com.quevedo.api.inmobiliaria_backend.infraestructure.mappers.EmpleadoMapper;
import com.quevedo.api.inmobiliaria_backend.infraestructure.mappers.UsuarioMapper;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.usuario.UsuarioDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UsuarioUpdateUseCase implements IUsuarioUpdateUseCase {

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
            Usuario usuarioUpdate = usuarioRepository.save(
                    new Usuario(
                            id,
                            usuarioDTO.getUsername(),
                            opt.get().getPassword(), // password no changed
                            usuarioDTO.getRol(),
                            usuarioDTO.getEquipoVenta(),
                            LocalDateTime.parse(usuarioDTO.getFechaRegistro()),
                            usuarioDTO.isEstado(),
                            EmpleadoMapper.fromDtoToEmpleado(usuarioDTO.getEmpleadoDTO())
                    )
            );
            return UsuarioMapper.toResponse(usuarioUpdate);

        }
        throw new EntityNotFoundException();
    }
}
