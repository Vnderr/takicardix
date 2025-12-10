package com.example.takicardix.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.takicardix.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByNombre(String nombre);

    Optional<Usuario> findByCorreo(String correo);
}
