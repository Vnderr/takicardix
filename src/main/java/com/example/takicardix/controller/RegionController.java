package com.example.takicardix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.takicardix.model.Region;
import com.example.takicardix.service.RegionService;

@RestController
@RequestMapping("/api/region")
public class RegionController {

    @Autowired
    private RegionService regionService;

    @GetMapping
    public ResponseEntity<List<Region>> getAllRegion() {
        List<Region> regiones = regionService.FindAll();
        if (regiones.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(regiones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Region> getRegionById(@PathVariable Integer id) {
        Region region = regionService.findById(id);
        if (region == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(region);
    }

    @PostMapping
    public ResponseEntity<Region> createRegion(@RequestBody Region region) {
        region.setRegion_id(null); 
        Region regionNew = regionService.save(region);
        return ResponseEntity.status(201).body(regionNew);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Region> updateRegion(@PathVariable Integer id, @RequestBody Region region) {
        region.setRegion_id(id);
        Region updateRegion = regionService.save(region);
        if (updateRegion == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updateRegion);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Region> updateParcialRegion(@PathVariable Integer id, @RequestBody Region region) {
        region.setRegion_id(id);
        Region updateRegion = regionService.partialUpdate(region);
        if (updateRegion == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updateRegion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRegion(@PathVariable Integer id) {
        regionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
