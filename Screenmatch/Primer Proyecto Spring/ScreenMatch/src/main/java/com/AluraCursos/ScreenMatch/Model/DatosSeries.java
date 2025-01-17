package com.AluraCursos.ScreenMatch.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosSeries(
        @JsonAlias("Title") String titulo,
        @JsonAlias("totalSeasons") Integer totalDeTemporadas,
        @JsonAlias("imdbRating") String evaluacion,
        @JsonAlias("Genre")String genero,
        @JsonAlias("Actors")String actores,
        @JsonAlias("Poster")String poster,
        @JsonAlias("Released")String fechaDeLanzamiento,
        @JsonAlias("Plot")String sinopsis){
}
