package com.quevedo.api.inmobiliaria_backend.infraestructure.mappers;

import com.quevedo.api.inmobiliaria_backend.domain.models.Contrato;
import com.quevedo.api.inmobiliaria_backend.infraestructure.entities.ContratoEntity;

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
                contrato.idContrato(),
                contrato.fechaInicio(),
                contrato.fechaFin(),
                contrato.tipoContrato(),
                EmpleadoMapper.toEntity(contrato.empleado())
        );
    }
}
