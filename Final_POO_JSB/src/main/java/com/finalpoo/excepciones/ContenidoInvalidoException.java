package com.finalpoo.excepciones;

public class ContenidoInvalidoException extends EnvioException {
    public ContenidoInvalidoException(String guia) {
        super("Paquete " + guia + ": un paquete frágil debe indicar qué contiene.");
    }
}
