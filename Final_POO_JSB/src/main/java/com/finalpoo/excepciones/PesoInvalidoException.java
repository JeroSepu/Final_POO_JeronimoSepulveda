package com.finalpoo.excepciones;

public class PesoInvalidoException extends EnvioException {
    public PesoInvalidoException(String guia, String motivo) {
        super("Paquete " + guia + ": peso inválido, " + motivo + ".");
    }
}
