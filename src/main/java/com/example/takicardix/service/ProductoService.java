package com.example.takicardix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.takicardix.model.Producto;
import com.example.takicardix.repository.ProductoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    public Producto findById(Integer id) {
        Producto producto = productoRepository.findById(id).orElse(null);
        return producto;
    }

    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto partialUpdate(Producto producto) {
        Producto existingProducto = productoRepository.findById(producto.getProducto_id()).orElse(null);
        if (existingProducto != null) {
            if (producto.getNombre() != null) {
                existingProducto.setNombre(producto.getNombre());
            }
            if (producto.getDescripcion() != null) {
                existingProducto.setDescripcion(producto.getDescripcion());
            }
            if (producto.getPrecio() != 0) {
                existingProducto.setPrecio(producto.getPrecio());
            }
            if (producto.getImageUrl() != null) {
                existingProducto.setImageUrl(producto.getImageUrl());
                
            }
            return productoRepository.save(existingProducto);
        } else {
            return null;
        }
    }

    public Producto update(Producto producto) {
        Producto existingProducto = productoRepository.findById(producto.getProducto_id()).orElse(null);
        if (existingProducto != null) {
            existingProducto.setNombre(producto.getNombre());
            existingProducto.setDescripcion(producto.getDescripcion());
            existingProducto.setPrecio(producto.getPrecio());
            existingProducto.setImageUrl(null);
            return productoRepository.save(existingProducto);
        } else {
            return null;
        }
    }

    public void deleteById(Integer id) {
        productoRepository.deleteById(id);
    }

    public void deleteByMarcaId(Integer marca_id) {
        List<Producto> productos = productoRepository.findAll();
        for (Producto producto : productos) {
            if (producto.getMarca() != null && producto.getMarca().getMarca_id().equals(marca_id)) {
                productoRepository.deleteById(producto.getProducto_id());
            }
        }
    }

    public Producto findByNombre(String nombre) {
        return productoRepository.findByNombre(nombre);
    }

    public Producto findByPrecio(int precio) {
        return productoRepository.findByPrecio(precio);
    }

}
