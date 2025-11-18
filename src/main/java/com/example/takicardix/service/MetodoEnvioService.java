package com.example.takicardix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.takicardix.model.MetodoEnvio;
import com.example.takicardix.repository.MetodoEnvioRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MetodoEnvioService {

    @Autowired
    private MetodoEnvioRepository metodoEnvioRepository;

    public List<MetodoEnvio> findAll() {
        return metodoEnvioRepository.findAll();
    }

    public MetodoEnvio findById(Integer id) {
        return metodoEnvioRepository.findById(id).orElse(null);
    }

    public MetodoEnvio save(MetodoEnvio metodoEnvio) {
        return metodoEnvioRepository.save(metodoEnvio);
    }

    public void deleteById(Integer id) {
        metodoEnvioRepository.deleteById(id);
    }

    public MetodoEnvio partialUpdate(MetodoEnvio metodoEnvio) {
        MetodoEnvio existingMetodoEnvio = metodoEnvioRepository.findById(metodoEnvio.getMetodo_envio_id()).orElse(null);
        if (existingMetodoEnvio != null) {
            if (metodoEnvio.getNombre() != null) {
                existingMetodoEnvio.setNombre(metodoEnvio.getNombre());
            }
            if (metodoEnvio.getCosto() != null) {
                existingMetodoEnvio.setCosto(metodoEnvio.getCosto());
            }
            return metodoEnvioRepository.save(existingMetodoEnvio);
        } else {
            return null;
        }
    }

    public MetodoEnvio update(MetodoEnvio metodoEnvio) {
        MetodoEnvio existingMetodoEnvio = metodoEnvioRepository.findById(metodoEnvio.getMetodo_envio_id()).orElse(null);
        if (existingMetodoEnvio != null) {
            existingMetodoEnvio.setNombre(metodoEnvio.getNombre());
            existingMetodoEnvio.setCosto(metodoEnvio.getCosto());
            return metodoEnvioRepository.save(existingMetodoEnvio);
        } else {
            return null;
        }
    }


}
