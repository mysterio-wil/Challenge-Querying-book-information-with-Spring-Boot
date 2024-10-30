package com.alura.SpringBootChallenge.principal;

import com.alura.SpringBootChallenge.model.Datos;
import com.alura.SpringBootChallenge.model.DatosLibros;
import com.alura.SpringBootChallenge.service.ConsumoAPI;
import com.alura.SpringBootChallenge.service.ConvierteDatos;

import java.util.Comparator;
import java.util.stream.IntStream;

public class Principal {
    // URL base para realizar la solicitud a la API externa
    private static final String URL_BASE = "https://gutendex.com/books/";

    // Instancia de ConsumoAPI para manejar las solicitudes a la API
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    // Instancia de ConvierteDatos para manejar la conversión de datos
    private ConvierteDatos conversor = new ConvierteDatos();

    // Método que muestra el menú principal de la aplicación
    public void muestraElMenu() {
        // Realiza una solicitud a la API y obtiene el JSON de respuesta
        var json = consumoAPI.obtenerDatos(URL_BASE);
        // Imprime el JSON obtenido en la consola
        System.out.println(json);
        var datos = conversor.obtenerDatos(json, Datos.class);
        System.out.println(datos);

        // Top 10 libros más descargados
        System.out.println("Top 10 libros más descargados");
        System.out.println("");
        IntStream.range(0, 10)
                .forEach(i -> {
                    System.out.println((i + 1) + ". " +
                            datos.resultados().stream()
                                    .sorted(Comparator.comparing(DatosLibros::numeroDeDescargas).reversed())
                                    .skip(i)
                                    .findFirst()
                                    .map(DatosLibros::titulo)
                                    .map(String::toUpperCase)
                                    .orElse("Sin datos"));
                });
    }
}