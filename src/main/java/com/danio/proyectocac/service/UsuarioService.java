package com.danio.proyectocac.service;

import com.danio.proyectocac.entity.Role;
import com.danio.proyectocac.exception.UsuarioNotFoundException;
import com.danio.proyectocac.entity.Usuario;
import com.danio.proyectocac.repository.RoleRepository;
import com.danio.proyectocac.repository.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service @Slf4j @Transactional
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final RoleRepository roleRepository;


    public UsuarioService(UsuarioRepository usuarioRepository, RoleRepository roleRepository) {
        this.usuarioRepository = usuarioRepository;
        this.roleRepository = roleRepository;
    }

    public Usuario findUsuarioById(Usuario usuario) {
        return usuarioRepository.findById(usuario.getId())
                .orElseThrow(() -> new UsuarioNotFoundException(usuario.getId()));
    }

    public Usuario saveUser(Usuario usuario) {
        log.info("Saving new user to the database");
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> getAllUsers(){
        return usuarioRepository.findAll();
    }

    public void deleteUser(Usuario usuario){
        usuarioRepository.delete(usuario);
    }

    public void AddRoleToUsuario(String username, String roleName){
        log.info("Adding role {} to user {}", roleName, username);
        Usuario usuario = usuarioRepository.findByUsername(username);
        Role role = roleRepository.findByName(roleName);
        usuario.getRoles().add(role);
    }
}
