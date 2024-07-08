package com.quevedo.api.inmobiliaria_backend.aplication.usecases.empleado.deleteById;

import com.quevedo.api.inmobiliaria_backend.domain.models.Empleado;
import com.quevedo.api.inmobiliaria_backend.domain.models.Usuario;
import com.quevedo.api.inmobiliaria_backend.domain.repositories.IEmpleadoRepository;
import com.quevedo.api.inmobiliaria_backend.domain.repositories.IUsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class EmpleadoDeleteByIdUseCase implements IEmpleadoDeleteByIdUseCase {

    private final IEmpleadoRepository empleadoRepository;
    private final IUsuarioRepository usuarioRepository;

    public EmpleadoDeleteByIdUseCase(IEmpleadoRepository empleadoRepository, IUsuarioRepository usuarioRepository) {
        this.empleadoRepository = empleadoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    @Transactional
    public void execute(int id) {
        // if empleado exist
        Optional<Empleado> optEmpleado = empleadoRepository.readById(id);
        if (optEmpleado.isPresent()) {
            // if empleado has usuario
            Optional<Usuario> optUsuario = usuarioRepository.buscarUsuarioEstadoTrue(id);

            // logic delete
            try {
                optUsuario.ifPresent(usuario -> {
                    usuario.setEstado(false);
                    usuarioRepository.save(usuario);
                });
                // logic delete empleado
                optEmpleado.get().setEstado(false);
                empleadoRepository.save(optEmpleado.get());

            }catch (Exception e) {
                throw new RuntimeException("Error al eliminar el empleado", e);
            }
        } else {
            throw new RuntimeException("No Eliminación, El id del empleado no existe");
        }

    }
}
