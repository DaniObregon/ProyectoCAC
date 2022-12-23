package com.danio.proyectocac.service;

import com.danio.proyectocac.exception.UsuarioNotFoundException;
import com.danio.proyectocac.entity.Usuario;
import com.danio.proyectocac.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario findUsuarioById(Usuario usuario) {
        return usuarioRepository.findById(usuario.getId())
                .orElseThrow(() -> new UsuarioNotFoundException(usuario.getId()));
    }

    public Usuario saveUser(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> getAllUsers(){
        return usuarioRepository.findAll();
    }

    public void deleteUser(Usuario usuario){
        usuarioRepository.delete(usuario);
    }
}
