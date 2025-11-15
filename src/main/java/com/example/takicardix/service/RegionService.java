package com.example.takicardix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.takicardix.model.Region;
import com.example.takicardix.repository.RegionRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RegionService {

    @Autowired
    private RegionRepository regionRepository;

    public List<Region> FindAll() {
        return regionRepository.findAll();
    }

    public Region findById(Integer id) {
        return regionRepository.findById(id).orElse(null);
    }   

    public Region save(Region region) {
        return regionRepository.save(region);
    }

    public void deleteById(Integer id) {
        regionRepository.deleteById(id);
    }

    public Region partialUpdate(Region region) {
        Region existingRegion = regionRepository.findById(region.getRegion_id()).orElse(null);
        if (existingRegion != null) {
            if (region.getNombre() != null) {
                existingRegion.setNombre(region.getNombre());
            }
            return regionRepository.save(existingRegion);
        } else {
            return null;
        }
    }

    public Region update(Region region) {
        Region existingRegion = regionRepository.findById(region.getRegion_id()).orElse(null);
        if (existingRegion != null) {
            existingRegion.setNombre(region.getNombre());
            return regionRepository.save(existingRegion);
        } else {
            return null;
        }
    }

}
