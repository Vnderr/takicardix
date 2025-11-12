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

}
