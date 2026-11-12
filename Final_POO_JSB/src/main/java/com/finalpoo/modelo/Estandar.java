package com.finalpoo.modelo;

public class Estandar extends Paquete {
    public Estandar(String guia, Zona zona, double peso) { super(guia, zona, peso); }

    @Override public double costoEnvio() { return costoBase(); }
    @Override public String servicio() { return "Estándar"; }
    @Override public String ajuste() { return "—"; }
}
