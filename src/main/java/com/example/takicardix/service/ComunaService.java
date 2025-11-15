package com.example.takicardix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.takicardix.model.Comuna;
import com.example.takicardix.repository.ComunaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ComunaService {

    @Autowired
    private ComunaRepository comunaRepository;

    public List<Comuna> FindAll(){
        return comunaRepository.findAll();
    }

    public Comuna findById(Integer id) {
        return comunaRepository.findById(id).orElse(null);
    }

    public Comuna save(Comuna comuna) {
        return comunaRepository.save(comuna);
    }

    public void deleteById(Integer id) {
        comunaRepository.deleteById(id);
    }

    public Comuna partialUpdate(Comuna comuna) {
        Comuna existingComuna = comunaRepository.findById(comuna.getId()).orElse(null);
        if (existingComuna != null) {
            if (comuna.getNombre() != null) {
                existingComuna.setNombre(comuna.getNombre());
            }
            if (comuna.getRegion() != null) {
                existingComuna.setRegion(comuna.getRegion());
            }
            return comunaRepository.save(existingComuna);
        } else {
            return null;
        }
    }

    public Comuna update(Comuna comuna) {
        Comuna existingComuna = comunaRepository.findById(comuna.getId()).orElse(null);
        if (existingComuna != null) {
            existingComuna.setNombre(comuna.getNombre());
            existingComuna.setRegion(comuna.getRegion());
            return comunaRepository.save(existingComuna);
        } else {
            return null;
        }
    }
}
