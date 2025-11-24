package com.example.takicardix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.takicardix.model.Venta;
import java.util.List;

public interface VentaRepository extends JpaRepository<Venta, Integer> {

List<Venta> findByUsuarioUsuarioId(Integer usuarioId);

}
