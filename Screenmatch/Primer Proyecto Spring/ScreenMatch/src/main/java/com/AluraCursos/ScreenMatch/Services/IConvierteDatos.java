package com.AluraCursos.ScreenMatch.Services;

public interface IConvierteDatos {

    <T> T obtenerDatos(String json, Class<T> clase);
}
