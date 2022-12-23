package com.danio.proyectocac.dto;

import com.danio.proyectocac.entity.Usuario;
import lombok.Data;

@Data
public class UsuarioDto {
    private Long id;
    private String nombreApellido;
    private String clave;
    private String usuario;

    public static UsuarioDto from(Usuario usuario) {
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setId(usuario.getId());
        usuarioDto.setNombreApellido(usuario.getNombreApellido());
        usuarioDto.setUsuario(usuario.getUsuario());
        usuarioDto.setClave(usuario.getClave());
        return usuarioDto;
    }
}
