package com.quevedo.api.inmobiliaria_backend.infraestructure.mappers;

import com.quevedo.api.inmobiliaria_backend.domain.models.Empleado;
import com.quevedo.api.inmobiliaria_backend.infraestructure.entities.EmpleadoEntity;

public class EmpleadoMapper {
    public static Empleado fromEntity(EmpleadoEntity entity) {
        return new Empleado(
                entity.getIdEmpleado(),
                entity.getNombre(),
                entity.getApellido(),
                entity.getEmail(),
                entity.getDNI(),
                entity.getTelefono(),
                entity.getDireccion(),
                entity.getFechaContratacion(),
                entity.getCargo(),
                entity.isEstado()
        );
    }

    public static EmpleadoEntity toEntity(Empleado empleado) {
        return new EmpleadoEntity(
                empleado.idEmpleado(),
                empleado.nombre(),
                empleado.apellido(),
                empleado.email(),
                empleado.DNI(),
                empleado.telefono(),
                empleado.direccion(),
                empleado.fechaContratacion(),
                empleado.cargo(),
                empleado.estado()
        );
    }
}
