package com.alura.SpringBootChallenge.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// Clase que representa los detalles de un autor, mapeando los campos de la API.
// Ignora propiedades desconocidas en el JSON para mayor flexibilidad.
@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosAutor(
        // Campo mapeado al nombre del autor en el JSON
        @JsonAlias("name") String nombre,

        // Campo mapeado a la fecha de nacimiento del autor en el JSON
        @JsonAlias("birth_day") String fechaDeNacimiento
) {
}