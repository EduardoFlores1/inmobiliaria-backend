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
                empleado.getIdEmpleado(),
                empleado.getNombre(),
                empleado.getApellido(),
                empleado.getEmail(),
                empleado.getDNI(),
                empleado.getTelefono(),
                empleado.getDireccion(),
                empleado.getFechaContratacion(),
                empleado.getCargo(),
                empleado.isEstado()
        );
    }

    public static EmpleadoDTO toResponse(Empleado e, Contrato c) {
        return new EmpleadoDTO(
                e.getIdEmpleado(),
                e.getNombre(),
                e.getApellido(),
                e.getEmail(),
                e.getDNI(),
                e.getTelefono(),
                e.getDireccion(),
                e.getFechaContratacion().toString(),
                e.getCargo(),
                e.isEstado(),
                c == null ? null : ContratoMapper.toResponse(c) //provide of usuarioMapper
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
