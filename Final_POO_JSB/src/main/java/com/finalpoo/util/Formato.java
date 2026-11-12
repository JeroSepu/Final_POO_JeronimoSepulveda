package com.finalpoo.util;

public final class Formato {

    private Formato() { }
    public static String dinero(double valor) {
        int entero = (int) valor;
        return "" + entero;
    }
    public static String peso(double kg) {
        int decimas = (int) (kg * 10);
        return decimas / 10.0 + " kg";
    }
}
