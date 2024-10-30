package com.alura.SpringBootChallenge.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

// Clase que representa los detalles de un libro, mapeando los campos de la API.
// Se utiliza JsonIgnoreProperties para evitar errores al procesar campos desconocidos.
@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibros<DatosAutor>(
        // Campo mapeado al título del libro en el JSON
        @JsonAlias("title") String titulo,

        // Campo que contiene la lista de autores, mapeado desde 'authors' en el JSON
        @JsonAlias("authors") List<DatosAutor> autor,

        // Lista de idiomas en los que está disponible el libro, mapeada desde 'languages'
        @JsonAlias("languages") List<String> idiomas,

        // Número de descargas, mapeado desde 'download_count' en el JSON
        @JsonAlias("download_count") Double numeroDeDescargas
) {
}

