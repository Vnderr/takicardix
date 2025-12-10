package com.example.takicardix.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.takicardix.repository.UsuarioRepository;

@Configuration
public class ApplicationConfig {

    private final UsuarioRepository usuarioRepository;

    public ApplicationConfig(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return correo -> usuarioRepository.findByCorreo(correo)
                .map(usuario -> org.springframework.security.core.userdetails.User.builder()
                        .username(usuario.getCorreo())
                        .password(usuario.getContrasena())
                        .roles(usuario.getRol() != null ? usuario.getRol().getNombre() : "USER")
                        .build())
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con correo: " + correo));
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
