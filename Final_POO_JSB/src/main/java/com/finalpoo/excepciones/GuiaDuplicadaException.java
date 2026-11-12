package com.finalpoo.excepciones;

public class GuiaDuplicadaException extends EnvioException {
    public GuiaDuplicadaException(String guia, String despacho) {
        super("Paquete " + guia + ": ya hay un paquete con esa guía en el despacho " + despacho + ", no se subió.");
    }
}
