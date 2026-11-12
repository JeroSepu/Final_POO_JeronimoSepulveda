package com.finalpoo.modelo;

public enum Zona {
    CENTRO("Centro", 6000), NORTE("Norte", 8000), SUR("Sur", 8000), ORIENTE("Oriente", 15000);

    private final String nombre;
    private final double tarifa;

    Zona(String nombre, double tarifa) {
        this.nombre = nombre;
        this.tarifa = tarifa;
    }
    public double getTarifa() { return tarifa; }

    @Override
    public String toString() { return nombre; }
}
