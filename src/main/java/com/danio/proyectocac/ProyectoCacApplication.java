package com.danio.proyectocac;

import com.danio.proyectocac.entity.Role;
import com.danio.proyectocac.entity.Usuario;
import com.danio.proyectocac.service.RoleService;
import com.danio.proyectocac.service.UsuarioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class ProyectoCacApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProyectoCacApplication.class, args);
    }

    @Bean
    CommandLineRunner run(UsuarioService usuarioService, RoleService roleService) {
        return args -> {
            roleService.saveRole(new Role(null, "ROLE_USER"));
            roleService.saveRole(new Role(null, "ROLE_MANAGER"));
            roleService.saveRole(new Role(null, "ROLE_ADMIN"));
            roleService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            usuarioService.saveUser(new Usuario(null, "John Travolta", "john", "1234", new ArrayList<>()));
            usuarioService.saveUser(new Usuario(null, "Jim Carry", "jim", "1234", new ArrayList<>()));
            usuarioService.saveUser(new Usuario(null, "Will Smith", "will", "1234", new ArrayList<>()));
            usuarioService.saveUser(new Usuario(null, "Arnold Schwarzenegger", "arnold", "1234", new ArrayList<>()));

            usuarioService.AddRoleToUsuario("john", "ROLE_USER");
            usuarioService.AddRoleToUsuario("john", "ROLE_MANAGER");
            usuarioService.AddRoleToUsuario("will", "ROLE_MANAGER");
            usuarioService.AddRoleToUsuario("jim", "ROLE_ADMIN");
            usuarioService.AddRoleToUsuario("arnold", "ROLE_SUPER_ADMIN");
            usuarioService.AddRoleToUsuario("arnold", "ROLE_ADMIN");
            usuarioService.AddRoleToUsuario("arnold", "ROLE_USER");

        };
    }

}
