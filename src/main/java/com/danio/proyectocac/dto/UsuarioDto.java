package com.danio.proyectocac.dto;

import com.danio.proyectocac.entity.Role;
import com.danio.proyectocac.entity.Usuario;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;

@Data
public class UsuarioDto {
    private Long id;
    private String nombreApellido;
    private String password;
    private String username;
    private Collection<Role> roles = new ArrayList<>();

    public static UsuarioDto from(Usuario usuario) {
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setId(usuario.getId());
        usuarioDto.setNombreApellido(usuario.getNombreApellido());
        usuarioDto.setUsername(usuario.getUsername());
        usuarioDto.setPassword(usuario.getPassword());
        usuarioDto.setRoles(usuario.getRoles());
        return usuarioDto;
    }
}
