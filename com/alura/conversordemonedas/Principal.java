package com.alura.conversordemonedas;

import java.util.Scanner;
import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        int opcion = 0;
        Scanner lectura = new Scanner(System.in);
        ConsultaApi consulta = new ConsultaApi();
        ConvertirValor conversor = new ConvertirValor();
        ArrayList<Valores> historial = new ArrayList<>();

        while (opcion != 8) {
            System.out.println("""
                    **************************************************
                    Sea bienvenido/a al Conversor de Monedas =] \n
                    1) Dolar =>> Peso argentino
                    2) Peso argentino =>> Dolar
                    3) Dolar =>> Real brasileño
                    4) Real brasileño =>> Dolar
                    5) Dolar =>> Peso colombiano
                    6) Peso colombiano =>> Dolar
                    7) Mostrar el historial de conversiones
                    8) Salir 
                    Elija una opción válida: \n
                    **************************************************
                    """);
            opcion = lectura.nextInt();

            if (opcion >= 1 && opcion <= 6) {
                System.out.println("Ingrese el valor que deseas convertir: ");
                int valor = lectura.nextInt();

                double valorApi;
                String monedaOrigen;
                String monedaDestino;

                switch (opcion) {
                    case 1:
                        valorApi = consulta.obtenerMoneda("USD").conversion_rates().ARS;
                        monedaOrigen = "USD";
                        monedaDestino = "ARS";
                        break;
                    case 2:
                        valorApi = consulta.obtenerMoneda("ARS").conversion_rates().USD;
                        monedaOrigen = "ARS";
                        monedaDestino = "USD";
                        break;
                    case 3:
                        valorApi = consulta.obtenerMoneda("USD").conversion_rates().BRL;
                        monedaOrigen = "USD";
                        monedaDestino = "BRL";
                        break;
                    case 4:
                        valorApi = consulta.obtenerMoneda("BRL").conversion_rates().USD;
                        monedaOrigen = "BRL";
                        monedaDestino = "USD";
                        break;
                    case 5:
                        valorApi = consulta.obtenerMoneda("USD").conversion_rates().COP;
                        monedaOrigen = "USD";
                        monedaDestino = "COP";
                        break;
                    case 6:
                        valorApi = consulta.obtenerMoneda("COP").conversion_rates().USD;
                        monedaOrigen = "COP";
                        monedaDestino = "USD";
                        break;
                    default:
                        valorApi = 0;
                        monedaOrigen = "";
                        monedaDestino = "";
                        break;
                }

                if (valorApi != 0) {
                    Valores valoresConvertidos = conversor.obtenerValorConvertido(valorApi, valor, monedaOrigen, monedaDestino);
                    historial.add(valoresConvertidos);
                }
            } else if (opcion == 7) {
                System.out.println("Historial de conversiones:");
                for (Valores valores : historial) {
                    System.out.println(valores);
                }
            } else if (opcion != 8) {
                System.out.println("Opción inválida. Por favor, elija una opción válida.");
            }
        }
    }
}
