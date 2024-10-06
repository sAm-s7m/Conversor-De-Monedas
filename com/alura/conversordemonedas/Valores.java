package com.alura.conversordemonedas;

public class Valores {
    public String conversion;
    public String tiempoDeConversion;

    public Valores(String conversion, String tiempoDeConversion) {
        this.conversion = conversion;
        this.tiempoDeConversion = tiempoDeConversion;
    }

    @java.lang.Override
    public String toString() {
        return "{" +
                "conversion = '" + conversion + '\'' +
                ", tiempoDeConversion = '" + tiempoDeConversion + '\'' +
                '}';
    }
}
