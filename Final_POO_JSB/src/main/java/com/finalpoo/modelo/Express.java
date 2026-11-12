package com.finalpoo.modelo;

public class Express extends Paquete {
    public Express(String guia, Zona zona, double peso) { super(guia, zona, peso); }

    @Override public double costoEnvio() { return costoBase() * 1.5; }
    @Override public String servicio() { return "Express"; }
    @Override public String ajuste() { return "x1.5"; }
    @Override public int prioridad() { return 0; }
}
