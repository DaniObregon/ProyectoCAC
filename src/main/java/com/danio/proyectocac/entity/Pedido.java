package com.danio.proyectocac.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String usuario;
    private String email;
    private String lugarEntrega;
    private int localidad;
    private int provincia;
    private String codigoPostal;
    private int formaPago;
    private String tarjetaTitular;
    private int tarjetaNumero;
    private String tarjetaVencimiento;
    private int tarjetaClave;

}
