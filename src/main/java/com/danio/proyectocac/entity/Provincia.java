package com.danio.proyectocac.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Provincia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private ProvinciaEnum provinciaEnum;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_idProvinciaLocalidad")
    private List<Localidad> localidades = new ArrayList<>();

    public void addLocalidad(Localidad localidad) {
        localidades.add(localidad);
    }

    public void removeLocalidad(Localidad localidad){
        localidades.remove(localidad);
    }
}
