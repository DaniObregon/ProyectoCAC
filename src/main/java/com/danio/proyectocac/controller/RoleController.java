package com.danio.proyectocac.controller;

import com.danio.proyectocac.entity.Role;
import com.danio.proyectocac.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    public ResponseEntity<Role> saveRole(@RequestBody Role role){
        return ResponseEntity.ok(roleService.saveRole(role));
    }
}
