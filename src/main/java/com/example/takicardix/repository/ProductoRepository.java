package com.example.takicardix.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.takicardix.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    Producto findByNombre(String nombre);

    //Producto findByPrecio(int precio); 
}
