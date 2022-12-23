package com.danio.proyectocac.entity;

public enum ProvinciaEnum {
    BUENOS_AIRES("Buenos Aires"),
    MENDOZA("Mendoza"),
    SAN_LUIS("San Luis"),
    NEUQUEN("Neuquen"),
    CORDOBA("Cordoba"),
    NOT_DEFINED("Provincia no definida");

    private String nombre;

    ProvinciaEnum(String nombre) {
        this.nombre = nombre;
    }

    public static ProvinciaEnum getNombre(String nombre){
        for(ProvinciaEnum p: values()){
            if(p.nombre.equalsIgnoreCase(nombre)){
                return p;
            }
        }
        return NOT_DEFINED;
    }
}
