package com.quevedo.api.inmobiliaria_backend.infraestructure.repositories.venta;

import com.quevedo.api.inmobiliaria_backend.domain.repositories.IVentaRepository;
import com.quevedo.api.inmobiliaria_backend.infraestructure.entities.VentaEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class VentaRepositoryJpa implements IVentaRepository {

    private final IVentaRepositoryJpa ventaRepositoryJpa;

    public VentaRepositoryJpa(IVentaRepositoryJpa ventaRepositoryJpa) {
        this.ventaRepositoryJpa = ventaRepositoryJpa;
    }

    @Override
    public List<VentaEntity> readAll() {
        return ventaRepositoryJpa.findAll();
    }

    @Override
    public Optional<VentaEntity> readById(Integer id) {
        return ventaRepositoryJpa.findById(id);
    }

    @Override
    public VentaEntity save(VentaEntity ventaEntity) {
        return ventaRepositoryJpa.save(ventaEntity);
    }

    @Override
    public void delete(int id) {
        ventaRepositoryJpa.deleteById(id);
    }
}
