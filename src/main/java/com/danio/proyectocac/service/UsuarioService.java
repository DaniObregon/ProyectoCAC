package com.danio.proyectocac.service;

import com.danio.proyectocac.entity.Role;
import com.danio.proyectocac.exception.UsuarioNotFoundException;
import com.danio.proyectocac.entity.Usuario;
import com.danio.proyectocac.repository.RoleRepository;
import com.danio.proyectocac.repository.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Slf4j
@Transactional
public class UsuarioService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsername(username);
        if (usuario == null) {
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User "+ username + " not found in the database.");
        } else {
            log.info("User {} found in the database", username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        usuario.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(usuario.getUsername(), usuario.getPassword(), authorities);
    }

    public UsuarioService(UsuarioRepository usuarioRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario findUsuarioById(Usuario usuario) {
        return usuarioRepository.findById(usuario.getId())
                .orElseThrow(() -> new UsuarioNotFoundException(usuario.getId()));
    }

    public Usuario saveUser(Usuario usuario) {
        log.info("Saving new user to the database");
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> getAllUsers() {
        return usuarioRepository.findAll();
    }

    public void deleteUser(Usuario usuario) {
        usuarioRepository.delete(usuario);
    }

    public void AddRoleToUsuario(String username, String roleName) {
        log.info("Adding role {} to user {}", roleName, username);
        Usuario usuario = usuarioRepository.findByUsername(username);
        Role role = roleRepository.findByName(roleName);
        usuario.getRoles().add(role);
    }
}
