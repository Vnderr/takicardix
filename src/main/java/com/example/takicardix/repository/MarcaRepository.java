package com.example.takicardix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.takicardix.model.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Integer> {

    Marca findByNombre(String nombre);
}
