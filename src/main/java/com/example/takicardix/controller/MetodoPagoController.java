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

import com.example.takicardix.model.MetodoPago;
import com.example.takicardix.service.MetodoPagoService;

@RestController
@RequestMapping("/api/metodoPago")
public class MetodoPagoController {

    @Autowired
    private MetodoPagoService metodoPagoService;

    @GetMapping
    public ResponseEntity<List<MetodoPago>> getAllMetodosPagos() {
        List<MetodoPago> metodoPagos = metodoPagoService.findAll();
        if (metodoPagos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(metodoPagos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MetodoPago> getMetodoPagoById(@PathVariable Integer id) {
        MetodoPago metodoPago = metodoPagoService.findById(id);
        if (metodoPago == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(metodoPago);
    }

    @PostMapping
    public ResponseEntity<MetodoPago> createMetodoPago(@RequestBody MetodoPago metodoPago) {
        metodoPago.setMetodo_pago_id(null); 
        MetodoPago metodoPagoNew = metodoPagoService.save(metodoPago);
        return ResponseEntity.status(201).body(metodoPagoNew);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MetodoPago> updateMetodoPago(@PathVariable Integer id, @RequestBody MetodoPago metodoPago) {
        metodoPago.setMetodo_pago_id(id);
        MetodoPago updateMetodoPago = metodoPagoService.save(metodoPago);
        if (updateMetodoPago == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updateMetodoPago);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MetodoPago> updateParcialMetodoPago(@PathVariable Integer id, @RequestBody MetodoPago metodoPago) {
        metodoPago.setMetodo_pago_id(id);
        MetodoPago updateMetodoPago = metodoPagoService.partialUpdate(metodoPago);
        if (updateMetodoPago == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updateMetodoPago);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMetodoPago(@PathVariable Integer id) {
        metodoPagoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
