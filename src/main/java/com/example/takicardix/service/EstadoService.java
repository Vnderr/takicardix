package com.example.takicardix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.takicardix.model.Estado;
import com.example.takicardix.repository.EstadoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public List<Estado> findAll() {
        return estadoRepository.findAll();
    }   

    public Estado findById(Integer id) {
        return estadoRepository.findById(id).orElse(null);
    }

    public Estado save(Estado estado) {
        return estadoRepository.save(estado);
    }

    public void deleteById(Integer id) {
        estadoRepository.deleteById(id);
    }

    public Estado partialUpdate(Estado estado) {
        Estado existingEstado = estadoRepository.findById(estado.getId()).orElse(null);
        if (existingEstado != null) {
            if (estado.getNombre() != null) {
                existingEstado.setNombre(estado.getNombre());
            }
            return estadoRepository.save(existingEstado);
        } else {
            return null;
        }
    }

    public Estado update(Estado estado) {
        Estado existingEstado = estadoRepository.findById(estado.getId()).orElse(null);
        if (existingEstado != null) {
            existingEstado.setNombre(estado.getNombre());
            return estadoRepository.save(existingEstado);
        } else {
            return null;
        }
    }

}
