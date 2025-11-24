package com.example.takicardix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.takicardix.model.Venta;
import com.example.takicardix.service.VentaService;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @GetMapping
    public ResponseEntity<List<Venta>> getAllVentas() {
        List<Venta> ventas = ventaService.findAll();
        if (ventas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(ventas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venta> getVentaById(@PathVariable Integer id) {
        Venta venta = ventaService.findById(id);
        if (venta == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(venta);
    }

    @PostMapping
    public ResponseEntity<Venta> createVenta(@RequestBody Venta venta) {
        venta.setVenta_id(null);
        Venta ventaNew = ventaService.save(venta);
        return ResponseEntity.status(201).body(ventaNew);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Venta> updateVenta(@PathVariable Integer id, @RequestBody Venta venta) {
        venta.setVenta_id(id);
        Venta updateVenta = ventaService.save(venta);
        if (updateVenta == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updateVenta);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Venta> updateParcialVenta(@PathVariable Integer id, @RequestBody Venta venta) {
        venta.setVenta_id(id);
        Venta updateVenta = ventaService.partialUpdate(venta);
        if (updateVenta == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updateVenta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVenta(@PathVariable Integer id) {
        ventaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/usuario/{usuarioId}")
public ResponseEntity<List<Venta>> getVentasByUsuario(@PathVariable Integer usuarioId) {
    List<Venta> ventas = ventaService.findByUsuarioId(usuarioId);
    if (ventas.isEmpty()) {
        return ResponseEntity.noContent().build();
    }
    return ResponseEntity.ok(ventas);
}
}
