package com.danio.proyectocac.controller;

import com.danio.proyectocac.entity.ProvinciaEnum;
import com.danio.proyectocac.service.ProvinciaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/provincias")
public class ProvinciaController {

    private final ProvinciaService provinciaService;

    public ProvinciaController(ProvinciaService provinciaService) {
        this.provinciaService = provinciaService;
    }

    @GetMapping("/{provinciaEnum}/localidades")
    public ResponseEntity<List<String>> getLocalidadesByProvinciaEnum(
            @PathVariable final ProvinciaEnum provinciaEnum) {
        List<String> nombres = provinciaService.getLocalidadesByProvinciaEnum(provinciaEnum);
        return new ResponseEntity<>(nombres, HttpStatus.OK);
    }

    //    @GetMapping("/{idProvincia}/localidades")
//    public ResponseEntity<List<String>> getLocalidadesByProvinciaId(Long idProvincia){
//        List<String> nombres = provinciaService.getLocalidadesByProvinciaId(idProvincia);
//        return new ResponseEntity<>(nombres, HttpStatus.OK);
//    }
}
