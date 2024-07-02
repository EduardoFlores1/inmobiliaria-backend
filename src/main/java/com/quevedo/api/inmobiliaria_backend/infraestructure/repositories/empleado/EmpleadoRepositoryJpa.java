package com.quevedo.api.inmobiliaria_backend.infraestructure.repositories.empleado;

import com.quevedo.api.inmobiliaria_backend.domain.models.Empleado;
import com.quevedo.api.inmobiliaria_backend.domain.repositories.IEmpleadoRepository;
import com.quevedo.api.inmobiliaria_backend.infraestructure.entities.EmpleadoEntity;
import com.quevedo.api.inmobiliaria_backend.infraestructure.mappers.EmpleadoMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EmpleadoRepositoryJpa implements IEmpleadoRepository {

    private final IEmpleadoRepositoryJpa empleadoRepositoryJpa;

    public EmpleadoRepositoryJpa(IEmpleadoRepositoryJpa empleadoRepositoryJpa) {
        this.empleadoRepositoryJpa = empleadoRepositoryJpa;
    }

    @Override
    public List<Empleado> readAll() {
        return empleadoRepositoryJpa.findAll().stream()
                .map(EmpleadoMapper::fromEntity).toList();
    }

    @Override
    public Optional<Empleado> readById(Integer id) {
        return empleadoRepositoryJpa.findById(id).map(EmpleadoMapper::fromEntity);
    }

    @Override
    public Empleado save(Empleado empleado) {
        EmpleadoEntity entity = EmpleadoMapper.toEntity(empleado);
        return EmpleadoMapper.fromEntity(empleadoRepositoryJpa.save(entity));
    }

    @Override
    public void delete(int id) {
        empleadoRepositoryJpa.deleteById(id);
    }
}
