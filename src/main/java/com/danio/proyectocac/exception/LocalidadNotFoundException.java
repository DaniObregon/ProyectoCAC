package com.danio.proyectocac.exception;

import java.text.MessageFormat;

public class LocalidadNotFoundException extends RuntimeException {
    public LocalidadNotFoundException(Long id) {
        super(MessageFormat.format("La locaidad con el id {0} no fue encontrada", id));
    }
}
