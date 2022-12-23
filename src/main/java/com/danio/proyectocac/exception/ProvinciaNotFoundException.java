package com.danio.proyectocac.exception;

import java.text.MessageFormat;

public class ProvinciaNotFoundException extends RuntimeException {
    public ProvinciaNotFoundException(Long id) {
        super(MessageFormat.format("No es posible encontrar la provincia con id {0}", id));
    }
}
