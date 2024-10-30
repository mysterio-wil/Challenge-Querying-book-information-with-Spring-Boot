package com.alura.SpringBootChallenge.principal;

import com.alura.SpringBootChallenge.model.Datos;
import com.alura.SpringBootChallenge.service.ConsumoAPI;
import com.alura.SpringBootChallenge.service.ConvierteDatos;

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
    }
}