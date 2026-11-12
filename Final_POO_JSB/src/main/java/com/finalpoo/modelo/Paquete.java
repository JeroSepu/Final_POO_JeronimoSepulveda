package com.finalpoo.modelo;
import com.finalpoo.excepciones.GuiaInvalidaException;
import com.finalpoo.excepciones.PesoInvalidoException;
import com.finalpoo.util.Formato;

public abstract class Paquete {
    private final String guia;
    private final Zona zona;
    private final double peso;

    protected Paquete(String guia, Zona zona, double peso) {
        if (!guiaValida(guia)) throw new GuiaInvalidaException(guia);
        if (peso <= 0) throw new PesoInvalidoException(guia, "debe ser mayor a 0 kg");
        if (peso > 20) throw new PesoInvalidoException(guia, "pesa más de 20 kg y no se puede llevar en moto");
        this.guia = guia;
        this.zona = zona;
        this.peso = peso;
    }

    private static boolean guiaValida(String guia) {
        if (guia == null || guia.length() != 6 || !guia.startsWith("EY")) return false;
        for (int i = 2; i < 6; i++) {
            if (!Character.isDigit(guia.charAt(i))) return false;
        }
        return true;
    }

    public abstract double costoEnvio();
    public abstract String servicio();
    public abstract String ajuste();

    public int prioridad() { return 1; }

    public double costoBase() { return zona.getTarifa() + 1000 * peso; }

    public String getGuia() { return guia; }
    public Zona getZona() { return zona; }
    public double getPeso() { return peso; }

    @Override
    public boolean equals(Object o) {
        return o instanceof Paquete && guia.equals(((Paquete) o).guia);
    }

    @Override
    public int hashCode() { return guia.hashCode(); }

    @Override
    public String toString() {
        return guia + " | " + servicio() + " | " + zona + " | " + Formato.peso(peso)
                + " | " + Formato.dinero(costoBase()) + " | " + ajuste() + " | " + Formato.dinero(costoEnvio());
    }
}
