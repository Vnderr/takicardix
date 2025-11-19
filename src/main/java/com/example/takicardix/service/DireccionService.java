package com.example.takicardix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.takicardix.model.Direccion;
import com.example.takicardix.repository.DireccionRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DireccionService {

    @Autowired
    private DireccionRepository direccionRepository;

    public List<Direccion> FindAll() {
        return direccionRepository.findAll();
    }

    public Direccion findById(Integer id) {
        return direccionRepository.findById(id).orElse(null);
    }

    public Direccion save(Direccion direccion) {
        return direccionRepository.save(direccion);
    }

    public void deleteById(Integer id) {
        direccionRepository.deleteById(id);
    }

    public Direccion partialUpdate(Direccion direccion) {
        Direccion existingDireccion = direccionRepository.findById(direccion.getDireccion_id()).orElse(null);
        if (existingDireccion != null) {
            if (direccion.getCalle() != null) {
                existingDireccion.setCalle(direccion.getCalle());
            }
            if (direccion.getNumero() != null) {
                existingDireccion.setNumero(direccion.getNumero());
            }
            if (direccion.getComuna() != null) {
                existingDireccion.setComuna(direccion.getComuna());
            }
            return direccionRepository.save(existingDireccion);
        } else {
            return null;
        }
    }

    public Direccion update(Direccion direccion) {
        Direccion existingDireccion = direccionRepository.findById(direccion.getDireccion_id()).orElse(null);
        if (existingDireccion != null) {
            existingDireccion.setCalle(direccion.getCalle());
            existingDireccion.setNumero(direccion.getNumero());
            existingDireccion.setComuna(direccion.getComuna());
            return direccionRepository.save(existingDireccion);
        } else {
            return null;
        }
    }

    public void deleteByComunaId(Integer comuna_id) {
        List<Direccion> direcciones = direccionRepository.findAll();
        for (Direccion direccion : direcciones) {
            if (direccion.getComuna() != null && direccion.getComuna().getComuna_id().equals(comuna_id)) {
                direccionRepository.deleteById(direccion.getDireccion_id());
            }
        }
    }

}
