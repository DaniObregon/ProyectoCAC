package com.danio.proyectocac.exception;

import java.text.MessageFormat;

public class UsuarioNotFoundException extends RuntimeException{
    public UsuarioNotFoundException(final Long id) {
        super(MessageFormat.format("Usuario con id {0} no encontrado", id));
    }
}
