package com.finalpoo.excepciones;

public class CapacidadExcedidaException extends EnvioException {
    public CapacidadExcedidaException(String guia, String despacho) {
        super("Paquete " + guia + ": no se subió, el despacho " + despacho + " pasaría de 30 kg.");
    }
}
