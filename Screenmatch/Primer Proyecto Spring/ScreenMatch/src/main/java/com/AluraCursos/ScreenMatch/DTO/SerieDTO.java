package com.AluraCursos.ScreenMatch.DTO;

import com.AluraCursos.ScreenMatch.Model.Categoria;


public record SerieDTO(Long id, String titulo,
         Integer totalDeTemporadas,
         Double evaluacion,
         Categoria genero,
         String actores,
         String poster,
         String fechaDeLanzamiento,
         String sinopsis) {
}
