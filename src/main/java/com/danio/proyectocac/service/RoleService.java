package com.danio.proyectocac.service;

import com.danio.proyectocac.entity.Role;
import com.danio.proyectocac.entity.Usuario;
import com.danio.proyectocac.repository.RoleRepository;
import com.danio.proyectocac.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    private final RoleRepository roleRepository;
    private final UsuarioRepository usuarioRepository;

    public RoleService(RoleRepository roleRepository, UsuarioRepository usuarioRepository) {
        this.roleRepository = roleRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public Role saveRole(Role role){
        return roleRepository.save(role);
    }
}
