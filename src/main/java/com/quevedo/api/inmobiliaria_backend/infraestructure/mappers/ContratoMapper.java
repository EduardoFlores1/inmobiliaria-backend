package com.quevedo.api.inmobiliaria_backend.infraestructure.mappers;

import com.quevedo.api.inmobiliaria_backend.domain.models.Contrato;
import com.quevedo.api.inmobiliaria_backend.domain.models.Empleado;
import com.quevedo.api.inmobiliaria_backend.infraestructure.entities.ContratoEntity;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.contrato.ContratoDTO;

import java.time.LocalDateTime;

public class ContratoMapper {
    public static Contrato fromEntity(ContratoEntity entity){
        return new Contrato(
                entity.getIdContrato(),
                entity.getFechaInicio(),
                entity.getFechaFin(),
                entity.getTipoContrato(),
                EmpleadoMapper.fromEntity(entity.getEmpleado())
        );
    }

    public static ContratoEntity toEntity(Contrato contrato){
        return new ContratoEntity(
                contrato.getIdContrato(),
                contrato.getFechaInicio(),
                contrato.getFechaFin(),
                contrato.getTipoContrato(),
                EmpleadoMapper.toEntity(contrato.getEmpleado())
        );
    }

    public static ContratoDTO toResponse(Contrato contrato) {
        return new ContratoDTO(
                contrato.getIdContrato(),
                contrato.getFechaInicio().toString(),
                contrato.getFechaFin().toString(),
                contrato.getTipoContrato()
        );
    }

    public static Contrato fromDtoToContrato(Empleado e, ContratoDTO dto) {
        return new Contrato(
                dto.getIdContrato(),
                LocalDateTime.parse(dto.getFechaInicio()),
                LocalDateTime.parse(dto.getFechaFin()),
                dto.getTipoContrato(),
                e
        );
    }
}
