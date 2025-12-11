package com.example.takicardix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.takicardix.model.Venta;

public interface VentaRepository extends JpaRepository<Venta, Integer> {

    List<Venta> findByUsuarioUsuarioId(Integer usuario_id);

}
