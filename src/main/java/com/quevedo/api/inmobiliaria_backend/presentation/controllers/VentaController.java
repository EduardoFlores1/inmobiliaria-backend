package com.quevedo.api.inmobiliaria_backend.presentation.controllers;

import com.quevedo.api.inmobiliaria_backend.aplication.usecases.venta.create.IVentaCreateUseCase;
import com.quevedo.api.inmobiliaria_backend.aplication.usecases.venta.otros.IVentaOtrosUseCase;
import com.quevedo.api.inmobiliaria_backend.aplication.usecases.venta.readAll.IVentaReadAllUseCase;
import com.quevedo.api.inmobiliaria_backend.aplication.usecases.venta.readById.IVentaReadByIdUseCase;
import com.quevedo.api.inmobiliaria_backend.aplication.usecases.venta.update.IVentaUpdateUseCase;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.cliente.ClienteDTO;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.generic.ResponseDTO;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.lote.LoteDTO;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.tipoLote.TipoLoteDTO;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.venta.VentaCreateDTO;
import com.quevedo.api.inmobiliaria_backend.presentation.dtos.venta.VentaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/ventas", produces = MediaType.APPLICATION_JSON_VALUE)
public class VentaController {

    private final IVentaReadAllUseCase ventaReadAllUseCase;
    private final IVentaCreateUseCase ventaCreateUseCase;
    private final IVentaUpdateUseCase ventaUpdateUseCase;
    private final IVentaReadByIdUseCase ventaReadByIdUseCase;
    private final IVentaOtrosUseCase ventaOtrosUseCase;

    public VentaController(IVentaReadAllUseCase ventaReadAllUseCase, IVentaCreateUseCase ventaCreateUseCase, IVentaUpdateUseCase ventaUpdateUseCase, IVentaReadByIdUseCase ventaReadByIdUseCase, IVentaOtrosUseCase ventaOtrosUseCase) {
        this.ventaReadAllUseCase = ventaReadAllUseCase;
        this.ventaCreateUseCase = ventaCreateUseCase;
        this.ventaUpdateUseCase = ventaUpdateUseCase;
        this.ventaReadByIdUseCase = ventaReadByIdUseCase;
        this.ventaOtrosUseCase = ventaOtrosUseCase;
    }

    @GetMapping
    public ResponseEntity<ResponseDTO<List<VentaDTO>>> readAll() {
        return ResponseEntity.ok(ResponseDTO.of(HttpStatus.OK, ventaReadAllUseCase.execute()));
    }

    @GetMapping("cliente/{estado}")
    public ResponseEntity<ResponseDTO<List<ClienteDTO>>> readAllClientes(@PathVariable boolean estado) {
        return ResponseEntity.ok(ResponseDTO.of(HttpStatus.OK, ventaOtrosUseCase.listClientes(estado)));
    }

    @GetMapping(value = "/lote/{tipoEstado}")
    public ResponseEntity<ResponseDTO<List<LoteDTO>>> readAllLote(@PathVariable String tipoEstado) {
        return ResponseEntity.ok(ResponseDTO.of(HttpStatus.OK, ventaOtrosUseCase.listLotes(tipoEstado)));
    }

    @GetMapping(value = "/tipoLote")
    public ResponseEntity<ResponseDTO<List<TipoLoteDTO>>> readAllTipoLote() {
        return ResponseEntity.ok(ResponseDTO.of(HttpStatus.OK, ventaOtrosUseCase.listTiposLotes()));
    }

    @GetMapping(value = "/{idVenta}")
    public ResponseEntity<ResponseDTO<VentaDTO>> readById(@PathVariable int idVenta) {
        return ResponseEntity.ok(ResponseDTO.of(HttpStatus.OK, ventaReadByIdUseCase.execute(idVenta)));
    }

    @PostMapping
    public ResponseEntity<ResponseDTO<VentaDTO>> create(@RequestBody VentaCreateDTO ventaCreateDTO) {
        return ResponseEntity.ok(ResponseDTO.of(HttpStatus.CREATED, ventaCreateUseCase.execute(ventaCreateDTO)));
    }

    @PutMapping(value = "/{idVenta}")
    public ResponseEntity<ResponseDTO<VentaDTO>> update(@PathVariable int idVenta, @RequestBody VentaDTO ventaDTO) {
        return ResponseEntity.ok(ResponseDTO.of(HttpStatus.OK, ventaUpdateUseCase.execute(idVenta, ventaDTO)));
    }


}
