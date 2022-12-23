package com.danio.proyectocac.controller;

import com.danio.proyectocac.dto.LocalidadDto;
import com.danio.proyectocac.entity.Localidad;
import com.danio.proyectocac.service.LocalidadService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("localidades")
public class LocalidadController {
    private final LocalidadService localidadService;

    public LocalidadController(LocalidadService localidadService) {
        this.localidadService = localidadService;
    }

    @GetMapping
    public ResponseEntity<List<LocalidadDto>> getAllLocalidades() {
        List<Localidad> localidades = localidadService.getAllLocalidades();
        List<LocalidadDto> localidadDtos = localidades
                .stream()
                .map(LocalidadDto::from)
                .collect(Collectors.toList());
        return new ResponseEntity<>(localidadDtos, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<LocalidadDto> saveLocalidad(LocalidadDto localidadDto) {
        Localidad localidad = Localidad.from(localidadDto);
        localidadService.saveLocalidad(localidad);
        return new ResponseEntity<>(LocalidadDto.from(localidad), HttpStatus.OK);
    }

    @DeleteMapping("/({id})")
    public ResponseEntity<Void> deleteLocalidad(@PathVariable final Long id){
        localidadService.deleteLocalidad(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
