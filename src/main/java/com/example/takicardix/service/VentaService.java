package com.example.takicardix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.takicardix.model.Venta;
import com.example.takicardix.repository.VentaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    public List<Venta> findAll() {
        return ventaRepository.findAll();
    }

    public Venta findById(Integer id) {
        return ventaRepository.findById(id).orElse(null);
    }

    public Venta save(Venta venta) {
        return ventaRepository.save(venta);
    }

    public void deleteById(Integer id) {
        ventaRepository.deleteById(id);
    }

    public Venta partialUpdate(Venta venta) {
        Venta existingVenta = ventaRepository.findById(venta.getVenta_id()).orElse(null);
        if (existingVenta != null) {
            if (venta.getFecha() != null) {
                existingVenta.setFecha(venta.getFecha());
            }
            if (venta.getTotal() != null) {
                existingVenta.setTotal(venta.getTotal());
            }
            return ventaRepository.save(existingVenta);
        } else {
            return null;
        }
    }

    public Venta update(Venta venta) {
        Venta existingVenta = ventaRepository.findById(venta.getVenta_id()).orElse(null);
        if (existingVenta != null) {
            existingVenta.setFecha(venta.getFecha());
            existingVenta.setTotal(venta.getTotal());
            return ventaRepository.save(existingVenta);
        } else {
            return null;
        }
    }

}
