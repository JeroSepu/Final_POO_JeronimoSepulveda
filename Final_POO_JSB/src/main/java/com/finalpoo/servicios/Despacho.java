package com.finalpoo.servicios;

import com.finalpoo.excepciones.CapacidadExcedidaException;
import com.finalpoo.excepciones.GuiaDuplicadaException;
import com.finalpoo.modelo.ManejoEspecial;
import com.finalpoo.modelo.Paquete;
import com.finalpoo.util.Formato;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Despacho {
    public static final double PESO_MAXIMO = 30;
    private static int contador = 0;

    private final String codigo;
    private final String mensajero;
    private final List<Paquete> paquetes = new ArrayList<>();

    public Despacho(String mensajero) {
        contador++;
        this.codigo = "D-" + contador;
        this.mensajero = mensajero;
    }

    // Si algo falla se lanza la excepción antes de agregar, así el despacho queda como estaba.
    public void agregar(Paquete p) {
        if (paquetes.contains(p)) throw new GuiaDuplicadaException(p.getGuia(), codigo);
        if (pesoTotal() + p.getPeso() > PESO_MAXIMO) throw new CapacidadExcedidaException(p.getGuia(), codigo);
        paquetes.add(p);
    }

    public double pesoTotal() {
        double total = 0;
        for (Paquete p : paquetes) total += p.getPeso();
        return total;
    }

    public double costoTotal() {
        double total = 0;
        for (Paquete p : paquetes) total += p.costoEnvio();
        return total;
    }

    public List<Paquete> ordenEntrega() {
        List<Paquete> orden = new ArrayList<>(paquetes);
        orden.sort(Comparator.comparingInt(Paquete::prioridad)
                .thenComparing(Paquete::getZona)
                .thenComparing(Paquete::getGuia));
        return orden;
    }

    public void imprimirManifiesto() {
        System.out.println("\nManifiesto: Despacho " + codigo + " – Mensajero:" + mensajero);
        System.out.println("Guía | Servicio | Zona | Peso | Costo base | Ajuste | Costo envío");
        String advertencias = "";
        for (Paquete p : ordenEntrega()) {
            System.out.println(p);
            if (p instanceof ManejoEspecial) advertencias += ((ManejoEspecial) p).advertencia() + "  ";
        }
        if (advertencias.isEmpty()) advertencias = "ninguna";
        System.out.println("Peso total: " + Formato.peso(pesoTotal()));
        System.out.println("Costo total: $" + Formato.dinero(costoTotal()));
        System.out.println("Advertencias: " + advertencias);
    }
}
