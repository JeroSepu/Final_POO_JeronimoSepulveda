package com.finalpoo.excepciones;

public class GuiaInvalidaException extends EnvioException {
    public GuiaInvalidaException(String guia) {
        super("Guía inválida '" + guia + "': debe ser EY seguido de exactamente 4 dígitos.");
    }
}
