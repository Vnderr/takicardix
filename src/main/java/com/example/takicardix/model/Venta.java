package com.example.takicardix.model;

import java.sql.Date;

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
    private Integer venta_id;

    @Column(name = "montoVenta", nullable = false)
    private Double monto;

    @Column(name = "fechaVenta", length = 50, nullable = false)
    private String fecha;

    @Column(name = "detalleVenta", length = 200, nullable = false)
    private String detalle;

    @Column(name="fecha_venta", nullable=false)
    private Date fecha_venta;

    @Column(name="Hora_venta", nullable=false)
    private Date hora_venta;

    

}
