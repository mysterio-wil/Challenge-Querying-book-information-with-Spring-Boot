package com.alura.SpringBootChallenge.service;

public interface IConvierteDatos {

    /**
     * Método genérico para convertir datos JSON en una instancia de una clase especificada.
     *
     * @param json  El JSON en formato de cadena a convertir.
     * @param clase La clase objetivo a la que se convertirá el JSON.
     * @param <T>   El tipo de clase que se espera obtener como resultado.
     * @return Una instancia de la clase especificada con los datos extraídos del JSON.
     */
    <T> T obtenerDatos(String json, Class<T> clase);
}

