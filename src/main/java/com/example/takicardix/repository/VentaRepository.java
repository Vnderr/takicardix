package com.example.takicardix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.takicardix.model.Venta;

public interface VentaRepository extends JpaRepository<Venta, Integer> {

    @Query("SELECT v FROM Venta v WHERE v.usuario.usuario_id = :usuarioId")
    List<Venta> findByUsuarioId(@Param("usuarioId") Integer usuarioId);

}
