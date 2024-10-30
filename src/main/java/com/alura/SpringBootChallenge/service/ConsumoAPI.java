package com.alura.SpringBootChallenge.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoAPI {

    // Método para obtener datos JSON de una URL específica
    public String obtenerDatos(String url) {
        HttpClient client = HttpClient.newHttpClient(); // Crear instancia de HttpClient
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url)) // Configurar la URI objetivo
                .build();

        HttpResponse<String> response = null;

        try {
            // Realizar la solicitud HTTP y recibir la respuesta como cadena JSON
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            // Captura errores de IO y lanza RuntimeException
            throw new RuntimeException("Error al enviar la solicitud", e);
        } catch (InterruptedException e) {
            // Captura interrupciones y lanza RuntimeException
            throw new RuntimeException("Solicitud interrumpida", e);
        }

        // Retorna el cuerpo de la respuesta JSON
        return response.body();
    }
}


