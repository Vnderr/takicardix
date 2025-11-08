package com.example.takicardix.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "ventas")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "montoVenta", nullable = false)
    private Double monto;

    @Column(name = "fechaVenta", length = 50, nullable = false)
    private String fecha;

    @Column(name = "detalleVenta", length = 200, nullable = false)
    private String detalle;

    

}
