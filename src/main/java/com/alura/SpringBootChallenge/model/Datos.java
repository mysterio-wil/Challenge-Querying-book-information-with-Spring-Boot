package com.alura.SpringBootChallenge.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

// Esta clase representa la estructura de datos para almacenar los resultados de la API.
// Se utiliza la anotación JsonIgnoreProperties para ignorar cualquier propiedad desconocida en la respuesta JSON.
@JsonIgnoreProperties(ignoreUnknown = true)
public record Datos(
        // Asocia el campo 'results' del JSON con el campo 'resultados' en la clase
        @JsonAlias("results") List<DatosLibros> resultados
) {
}
