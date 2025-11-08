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
@Table(name = "direcciones")
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer producto_id;

    @Column(name = "calle", length = 50, nullable = false)
    private String calle;

    @Column(name = "ciudad", length = 50, nullable = false)
    private String ciudad;  

    @Column(name = "numero", nullable = false)
    private Integer numero;

}
