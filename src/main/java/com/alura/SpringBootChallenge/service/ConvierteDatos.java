package com.alura.SpringBootChallenge.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvierteDatos implements IConvierteDatos {

    // Instancia de ObjectMapper para convertir JSON a objetos Java
    private ObjectMapper mapper = new ObjectMapper();

    // Método para convertir datos JSON a una instancia de la clase especificada
    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {
        try {
            // Lee el JSON y lo convierte a la clase especificada
            return mapper.readValue(json, clase);
        } catch (JsonProcessingException e) {
            // Maneja la excepción si el procesamiento JSON falla
            throw new RuntimeException("Error al procesar JSON", e);
        }
    }
}

