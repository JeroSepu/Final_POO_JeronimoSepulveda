package com.finalpoo.modelo;

import com.finalpoo.excepciones.ContenidoInvalidoException;
import com.finalpoo.util.Formato;

public class Fragil extends Paquete implements ManejoEspecial {
    private static final double RECARGO = 5000;
    private final String contenido;

    public Fragil(String guia, Zona zona, double peso, String contenido) {
        super(guia, zona, peso);
        if (contenido == null || contenido.isEmpty()) throw new ContenidoInvalidoException(guia);
        this.contenido = contenido;
    }

    @Override public double costoEnvio() { return costoBase() + RECARGO; }
    @Override public String servicio() { return "Frágil (" + contenido + ")"; }
    @Override public String ajuste() { return "+" + Formato.dinero(RECARGO); }
    @Override public String advertencia() { return getGuia() + " · FRÁGIL (" + contenido + ")"; }
}
