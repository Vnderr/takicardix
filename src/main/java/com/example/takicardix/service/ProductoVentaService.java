package com.example.takicardix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.takicardix.model.ProductoVenta;
import com.example.takicardix.repository.ProductoVentaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductoVentaService {

    @Autowired
    private ProductoVentaRepository productoVentaRepository;

    public List<ProductoVenta> findAll() {
        return productoVentaRepository.findAll();
    }

    public ProductoVenta findById(Integer id) {
        return productoVentaRepository.findById(id).orElse(null);
    }

    public ProductoVenta save(ProductoVenta productoVenta) {
        return productoVentaRepository.save(productoVenta);
    }

    public void deleteById(Integer id) {
        productoVentaRepository.deleteById(id);
    }

    public ProductoVenta partialUpdate(ProductoVenta productoVenta) {
        ProductoVenta existingProductoVenta = productoVentaRepository.findById(productoVenta.getProducto_venta_id()).orElse(null);
        if (existingProductoVenta != null) {
            if (productoVenta.getProducto_venta_id() != null) {
                existingProductoVenta.setProducto_venta_id(productoVenta.getProducto_venta_id());
            }
            if (productoVenta.getCantidad() != null) {
                existingProductoVenta.setCantidad(productoVenta.getCantidad());

            }
            return productoVentaRepository.save(existingProductoVenta);
        } else {
            return null;
        }
    }

    public ProductoVenta update(ProductoVenta productoVenta) {
        ProductoVenta existingProductoVenta = productoVentaRepository.findById(productoVenta.getProducto_venta_id()).orElse(null);
        if (existingProductoVenta != null) {
            existingProductoVenta.setProducto_venta_id(productoVenta.getProducto_venta_id());
            existingProductoVenta.setCantidad(productoVenta.getCantidad());
            return productoVentaRepository.save(existingProductoVenta);
        } else {
            return null;
        }
    }
}
