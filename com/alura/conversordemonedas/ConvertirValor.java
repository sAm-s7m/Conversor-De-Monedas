package com.alura.conversordemonedas;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConvertirValor {
    private DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    public Valores obtenerValorConvertido(double valorApi, double valor, String codigoISO, String codigoISOApi) {
        LocalDateTime now = LocalDateTime.now();
        String tiempoDeConversion = now.format(format);
        double resultado = Math.round(valorApi * valor);
        String conversion = "El valor $" + valor + " [" + codigoISO + "] corresponde al valor final de =>>> $" + resultado + " [" + codigoISOApi + "] \n";
        System.out.println(conversion);
        Valores valores = new Valores(conversion, tiempoDeConversion);
        return valores;
    }
}