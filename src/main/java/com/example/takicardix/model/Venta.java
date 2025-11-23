package com.example.takicardix.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ventas")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer venta_id;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "montoVenta", nullable = false)
    private Double monto;

    @Column(name = "detalleVenta", length = 200, nullable = false)
    private String detalle;

    @Column(name = "fecha_venta", nullable = false)
    private Date fecha_venta;

    @Column(name = "total", nullable = false)
    private Integer total;

    @ManyToOne
    @JoinColumn(name = "metodo_pago_id")
    private MetodoPago metodoPago;

    @ManyToOne
    @JoinColumn(name = "metodo_envio_id")
    private MetodoEnvio metodoEnvio;

    @ManyToOne
    @JoinColumn(name = "estado_id")
    private Estado estado;

    @ManyToOne
    @JoinColumn(name = "producto_venta_id")
    private ProductoVenta productoVenta;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Column(name = "direccion")
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "comuna_id")
    private Comuna comuna;

}
