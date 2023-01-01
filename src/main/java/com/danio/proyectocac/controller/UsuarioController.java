package com.danio.proyectocac.controller;

import com.danio.proyectocac.dto.UsuarioDto;
import com.danio.proyectocac.dto.RoleToUser;
import com.danio.proyectocac.entity.Usuario;
import com.danio.proyectocac.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/save")
    public ResponseEntity<UsuarioDto> addUser(@RequestBody final Usuario usuario) {
        usuarioService.saveUser(usuario);
        return new ResponseEntity<>(UsuarioDto.from(usuario), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDto>> getAllUsers() {
        List<Usuario> usuarios = usuarioService.getAllUsers();
        List<UsuarioDto> usuarioDtos = usuarios.stream().map(UsuarioDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(usuarioDtos, HttpStatus.OK);
    }

    @PostMapping("/role/addtouser")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUser roleToUser) {
        usuarioService.AddRoleToUsuario(roleToUser.getName(), roleToUser.getUsername());
        return ResponseEntity.ok().build();
    }
}