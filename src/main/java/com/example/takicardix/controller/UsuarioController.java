package com.example.takicardix.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.takicardix.model.Usuario;
import com.example.takicardix.service.UsuarioService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        List<Usuario> usuarios = usuarioService.findAll();
        if (usuarios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(usuarios);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario usuario) {
        Usuario login = usuarioService.login(usuario);

        if (login != null) {
            login.setContrasena(null);
            return ResponseEntity.ok(login);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales Incorrectas");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Integer id) {
        Usuario usuario = usuarioService.findById(id);
        
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        } 
        return ResponseEntity.ok(usuario);
    }
    
    @PostMapping()
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
        usuario.setUsuario_id(null);
        Usuario newUsuario = usuarioService.save(usuario);
        return ResponseEntity.status(201).body(newUsuario);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Integer id,@RequestBody Usuario usuario) {
        usuario.setUsuario_id(id);
        Usuario updatedUsuario = usuarioService.save(usuario);

        if (updatedUsuario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedUsuario);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Usuario> updateParcialUsuario(@PathVariable Integer id,@RequestBody Usuario usuario) {
        usuario.setUsuario_id(id);
        Usuario updatedUsuario = usuarioService.partialUpdate(usuario);

        if (updatedUsuario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedUsuario);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Integer id) {
        usuarioService.deleteById(id);
        return ResponseEntity.noContent().build();  
    }  
    
    
}
