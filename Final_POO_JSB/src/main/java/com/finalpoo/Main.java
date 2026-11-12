package com.finalpoo;

import com.finalpoo.excepciones.EnvioException;
import com.finalpoo.modelo.Estandar;
import com.finalpoo.modelo.Express;
import com.finalpoo.modelo.Fragil;
import com.finalpoo.modelo.Zona;
import com.finalpoo.servicios.Despacho;

public class Main {
    public static void main(String[] args) {
        // ===== CASO 1 =====
        System.out.println("===== CASO 1 =====");
        Despacho andres = new Despacho("Andrés");

        try {
            andres.agregar(new Estandar("EY2001", Zona.ORIENTE, 5));
        } catch (EnvioException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        try {
            andres.agregar(new Express("EY2002", Zona.NORTE, 1.5));
        } catch (EnvioException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        try {
            andres.agregar(new Fragil("EY2003", Zona.CENTRO, 2, "vajilla"));
        } catch (EnvioException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        try {
            andres.agregar(new Estandar("EY2004", Zona.CENTRO, 8));
        } catch (EnvioException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        try {
            andres.agregar(new Express("EY2005", Zona.ORIENTE, 6));
        } catch (EnvioException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        try {
            andres.agregar(new Fragil("EY2006", Zona.SUR, 3.5, "televisor"));
        } catch (EnvioException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        andres.imprimirManifiesto();

        // ===== CASO 2 =====
        System.out.println("\n===== CASO 2 =====");

        try {
            new Estandar("EY3001", Zona.CENTRO, -2);
        } catch (EnvioException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        try {
            new Fragil("EY3002", Zona.NORTE, 2, "");
        } catch (EnvioException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        try {
            new Estandar("EY12A4", Zona.SUR, 3);
        } catch (EnvioException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        try {
            new Express("EY3003", Zona.NORTE, 22);
        } catch (EnvioException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        // ===== CASO 3 =====
        System.out.println("\n===== CASO 3 =====");
        Despacho camila = new Despacho("Camila");

        try {
            camila.agregar(new Estandar("EY4001", Zona.CENTRO, 12));
        } catch (EnvioException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        try {
            camila.agregar(new Express("EY4002", Zona.SUR, 10));
        } catch (EnvioException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        try {
            camila.agregar(new Fragil("EY4003", Zona.NORTE, 9, "espejo"));
        } catch (EnvioException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        try {
            camila.agregar(new Estandar("EY4004", Zona.ORIENTE, 8));
        } catch (EnvioException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        camila.imprimirManifiesto();

        // ===== CASO 4 =====
        System.out.println("\n===== CASO 4 =====");
        Despacho mateo = new Despacho("Mateo");

        try {
            mateo.agregar(new Fragil("EY5001", Zona.SUR, 3, "lámpara"));
        } catch (EnvioException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        try {
            mateo.agregar(new Estandar("EY5001", Zona.CENTRO, 1));
        } catch (EnvioException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        try {
            mateo.agregar(new Express("EY5002", Zona.CENTRO, 2));
        } catch (EnvioException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        mateo.imprimirManifiesto();
    }
}
