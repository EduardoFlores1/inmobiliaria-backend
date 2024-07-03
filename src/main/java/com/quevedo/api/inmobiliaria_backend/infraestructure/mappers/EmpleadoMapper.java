package com.quevedo.api.inmobiliaria_backend.infraestructure.mappers;

import com.quevedo.api.inmobiliaria_backend.domain.models.Contrato;
import com.quevedo.api.inmobiliaria_backend.domain.models.Empleado;
import com.quevedo.api.inmobiliaria_backend.infraestructure.entities.EmpleadoEntity;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.empleado.EmpleadoDTO;

import java.time.LocalDateTime;

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

    public static EmpleadoDTO toResponse(Empleado e, Contrato c) {
        return new EmpleadoDTO(
                e.idEmpleado(),
                e.nombre(),
                e.apellido(),
                e.email(),
                e.DNI(),
                e.telefono(),
                e.direccion(),
                e.fechaContratacion().toString(),
                e.cargo(),
                e.estado(),
                ContratoMapper.toResponse(c)
        );
    }

    public static Empleado fromDtoToEmpleado(EmpleadoDTO dto) {
        return new Empleado(
                dto.getIdEmpleado(),
                dto.getNombre(),
                dto.getApellido(),
                dto.getEmail(),
                dto.getDNI(),
                dto.getTelefono(),
                dto.getDireccion(),
                LocalDateTime.parse(dto.getFechaContratacion()),
                dto.getCargo(),
                dto.isEstado()
        );
    }
}
