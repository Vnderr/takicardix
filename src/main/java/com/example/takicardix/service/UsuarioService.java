package com.example.takicardix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.takicardix.model.Usuario;
import com.example.takicardix.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
@SuppressWarnings("null")
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario findById(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deleteById(Integer id) {
        usuarioRepository.deleteById(id);
    }

    //Funcion login
    public Usuario login (Usuario usuario) {
        Usuario foundUsuario = usuarioRepository.findByCorreo(usuario.getCorreo());

        if (foundUsuario != null && passwordEncoder.matches(usuario.getContrasena(), foundUsuario.getContrasena())){
            return foundUsuario;
        }
        return null;
    }

    //Patch
    public Usuario partialUpdate(Usuario usuario){
        Usuario existingUsuario = usuarioRepository.findById(usuario.getUsuario_id()).orElse(null);
        if (existingUsuario != null) {
            if (usuario.getNombre() != null) {
                existingUsuario.setNombre(usuario.getNombre());
            }
            if (usuario.getCorreo() != null) {
                existingUsuario.setCorreo(usuario.getCorreo());
            }

            if(usuario.getContrasena() != null) {
                existingUsuario.setContrasena(passwordEncoder.encode(usuario.getContrasena()));
            }

            if(usuario.getRol() != null) {
                existingUsuario.setRol(usuario.getRol());
            }

            return usuarioRepository.save(existingUsuario);
        }
        return null;
    }

    public Usuario update(Usuario usuario) {
        Usuario existingUsuario = usuarioRepository.findById(usuario.getUsuario_id()).orElse(null);
        if (existingUsuario != null) {
            existingUsuario.setNombre(usuario.getNombre());
            existingUsuario.setCorreo(usuario.getCorreo());
            existingUsuario.setContrasena(passwordEncoder.encode(usuario.getContrasena()));
            existingUsuario.setRol(usuario.getRol());
            return usuarioRepository.save(existingUsuario);
        } else {
            return null;
        }
    }

}
