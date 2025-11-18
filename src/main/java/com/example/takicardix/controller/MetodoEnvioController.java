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

import com.example.takicardix.model.MetodoEnvio;
import com.example.takicardix.service.MetodoEnvioService;

@RestController
@RequestMapping("/api/MetodoEnvio")
public class MetodoEnvioController {

    @Autowired
    private MetodoEnvioService metodoEnvioService;

    @GetMapping
    public ResponseEntity<List<MetodoEnvio>> getAllMetodosEnvios() {
        List<MetodoEnvio> metodoEnvios = metodoEnvioService.findAll();
        if (metodoEnvios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(metodoEnvios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MetodoEnvio> getMetodoEnvioById(@PathVariable Integer id) {
        MetodoEnvio metodoEnvio = metodoEnvioService.findById(id);
        if (metodoEnvio == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(metodoEnvio);
    }

    @PostMapping
    public ResponseEntity<MetodoEnvio> createMetodoEnvio(@RequestBody MetodoEnvio metodoEnvio) {
        metodoEnvio.setMetodo_envio_id(null);
        MetodoEnvio metodoEnvioNew = metodoEnvioService.save(metodoEnvio);
        return ResponseEntity.status(201).body(metodoEnvioNew);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MetodoEnvio> updatemetodoEnvio(@PathVariable Integer id, @RequestBody MetodoEnvio metodoEnvio) {
        metodoEnvio.setMetodo_envio_id(id);
        MetodoEnvio updateMetodoEnvio = metodoEnvioService.save(metodoEnvio);
        if (updateMetodoEnvio == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updateMetodoEnvio);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MetodoEnvio> updateParcialMetodoEnvio(@PathVariable Integer id, @RequestBody MetodoEnvio metodoEnvio) {
        metodoEnvio.setMetodo_envio_id(id);
        MetodoEnvio updateMetodoEnvio = metodoEnvioService.partialUpdate(metodoEnvio);
        if (updateMetodoEnvio == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updateMetodoEnvio);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMetodoEnvio(@PathVariable Integer id) {
        metodoEnvioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
