package com.example.takicardix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.takicardix.model.Rol;
import com.example.takicardix.repository.RolRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    public List<Rol> findAll() {
        return rolRepository.findAll();
    }

    public Rol findById(Integer id) {
        return rolRepository.findById(id).orElse(null);
    }

    public Rol save(Rol rol) {
        return rolRepository.save(rol);
    }

    public void deleteById(Integer id) {
        rolRepository.deleteById(id);
    }

    public Rol partialUpdate(Rol rol) {
        Rol existingRol = rolRepository.findById(rol.getRol_id()).orElse(null);
        if (existingRol != null) {
            if (rol.getNombre() != null) {
                existingRol.setNombre(rol.getNombre());
            }
            return rolRepository.save(existingRol);
        } else {
            return null;
        }
    }

    public Rol update(Rol rol) {
        Rol existingRol = rolRepository.findById(rol.getRol_id()).orElse(null);
        if (existingRol != null) {
            existingRol.setNombre(rol.getNombre());
            return rolRepository.save(existingRol);
        } else {
            return null;
        }
    }

}
