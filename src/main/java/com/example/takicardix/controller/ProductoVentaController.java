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

import com.example.takicardix.model.ProductoVenta;
import com.example.takicardix.service.ProductoVentaService;

@RestController
@RequestMapping("/api/productoVenta")
public class ProductoVentaController {

    @Autowired
    private ProductoVentaService productoVentaService;

    @GetMapping
    public ResponseEntity<List<ProductoVenta>> getAllProductosVentas() {
        List<ProductoVenta> productoVentas = productoVentaService.findAll();
        if (productoVentas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(productoVentas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoVenta> getProductoVentaById(@PathVariable Integer id) {
        ProductoVenta productoVenta = productoVentaService.findById(id);
        if (productoVenta == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productoVenta);
    }

    @PostMapping
    public ResponseEntity<ProductoVenta> createProductoVenta(@RequestBody ProductoVenta productoVenta) {
        productoVenta.setProducto_venta_id(null);
        ProductoVenta productoVentaNew = productoVentaService.save(productoVenta);
        return ResponseEntity.status(201).body(productoVentaNew);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoVenta> updateProductoVenta(@PathVariable Integer id, @RequestBody ProductoVenta productoVenta) {
        productoVenta.setProducto_venta_id(id);
        ProductoVenta updateProductoVenta = productoVentaService.save(productoVenta);
        if (updateProductoVenta == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updateProductoVenta);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProductoVenta> updateParcialProductoVenta(@PathVariable Integer id, @RequestBody ProductoVenta productoVenta) {
        productoVenta.setProducto_venta_id(id);
        ProductoVenta updateProductoVenta = productoVentaService.partialUpdate(productoVenta);
        if (updateProductoVenta == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updateProductoVenta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductoVenta(@PathVariable Integer id) {
        productoVentaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
