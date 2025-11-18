package com.example.takicardix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.takicardix.model.Marca;
import com.example.takicardix.repository.MarcaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    public List<Marca> findAll() {
        return marcaRepository.findAll();
    }

    public Marca findById(Integer id) {
        return marcaRepository.findById(id).orElse(null);
    }

    public Marca save(Marca marca) {
        return marcaRepository.save(marca);
    }

    public void deleteById(Integer id) {
        marcaRepository.deleteById(id);
    }

    public Marca partialUpdate(Marca marca) {
        Marca existingMarca = marcaRepository.findById(marca.getMarca_id()).orElse(null);
        if (existingMarca != null) {
            if (marca.getNombre() != null) {
                existingMarca.setNombre(marca.getNombre());
            }
            return marcaRepository.save(existingMarca);
        } else {
            return null;
        }
    }

    public Marca update(Marca marca) {
        Marca existingMarca = marcaRepository.findById(marca.getMarca_id()).orElse(null);
        if (existingMarca != null) {
            existingMarca.setNombre(marca.getNombre());
            return marcaRepository.save(existingMarca);
        } else {
            return null;
        }   
    }

    public void deleteByMarcaId(Integer id) {
        marcaRepository.deleteById(id);
    }

}
