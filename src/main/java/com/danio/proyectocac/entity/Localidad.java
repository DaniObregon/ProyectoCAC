package com.danio.proyectocac.entity;

import com.danio.proyectocac.dto.LocalidadDto;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Localidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private ProvinciaEnum provinciaEnum;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_idProvinciaLocalidad")
    private Provincia provincia;

    public static Localidad from(LocalidadDto localidadDto) {
        Localidad localidad = new Localidad();
        localidad.setNombre(localidadDto.getNombre());
        localidad.setProvinciaEnum(localidadDto.getProvinciaEnum());
        return localidad;
    }
}
