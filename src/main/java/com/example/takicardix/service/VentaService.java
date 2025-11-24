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

    public Venta partialUpdate(Venta venta){
        Venta existingVenta = ventaRepository.findById(venta.getVenta_id()).orElse(null);
        if (existingVenta != null) {
            if (venta.getMonto() != null) {
                existingVenta.setMonto(venta.getMonto());
            }
            if (venta.getDetalle() != null) {
                existingVenta.setDetalle(venta.getDetalle());
            }
            if (venta.getFecha_venta() != null) {
                existingVenta.setFecha_venta(venta.getFecha_venta());
            }
            if (venta.getTotal() != null) {
                existingVenta.setTotal(venta.getTotal());
            }
            return ventaRepository.save(existingVenta);
        }
        return null;
    }

    public Venta update(Venta venta) {
        Venta existingVenta = ventaRepository.findById(venta.getVenta_id()).orElse(null);
        if (existingVenta != null) {
            existingVenta.setMonto(venta.getMonto());
            existingVenta.setDetalle(venta.getDetalle());
            existingVenta.setFecha_venta(venta.getFecha_venta());
            existingVenta.setTotal(venta.getTotal());
            return ventaRepository.save(existingVenta);
        }
        return null;
    } 


}
