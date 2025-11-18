package com.example.takicardix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.takicardix.model.MetodoPago;
import com.example.takicardix.repository.MetodoPagoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MetodoPagoService {

    @Autowired
    private MetodoPagoRepository metodoPagoRepository;

    public List<MetodoPago> findAll() {
        return metodoPagoRepository.findAll();
    }

    public MetodoPago findById(Integer id) {
        return metodoPagoRepository.findById(id).orElse(null);
    }

    public MetodoPago save(MetodoPago metodoPago) {
        return metodoPagoRepository.save(metodoPago);
    }

    public void deleteById(Integer id) {
        metodoPagoRepository.deleteById(id);
    }

    public MetodoPago partialUpdate(MetodoPago metodoPago) {
        MetodoPago existingMetodoPago = metodoPagoRepository.findById(metodoPago.getMetodo_pago_id()).orElse(null);
        if (existingMetodoPago != null) {
            if (metodoPago.getNombre() != null) {
                existingMetodoPago.setNombre(metodoPago.getNombre());
            }
            return metodoPagoRepository.save(existingMetodoPago);
        } else {
            return null;
        }
    }

    public MetodoPago update(MetodoPago metodoPago) {
        MetodoPago existingMetodoPago = metodoPagoRepository.findById(metodoPago.getMetodo_pago_id()).orElse(null);
        if (existingMetodoPago != null) {
            existingMetodoPago.setNombre(metodoPago.getNombre());
            return metodoPagoRepository.save(existingMetodoPago);
        } else {
            return null;
        }
    }

}
