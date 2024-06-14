package com.AluraCursos.ScreenMatch.Repository;

import com.AluraCursos.ScreenMatch.DTO.EpisodioDTO;
import com.AluraCursos.ScreenMatch.Model.Categoria;
import com.AluraCursos.ScreenMatch.Model.Episodio;
import com.AluraCursos.ScreenMatch.Model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SerieRepository extends JpaRepository<Serie, Long> {

    Optional<Serie> findByTituloContainsIgnoreCase(String nombreSerie);

    List<Serie> findTop5ByOrderByEvaluacionDesc();

    List<Serie> findByGenero(Categoria categoria);

    //List<Serie> findByTotalDeTemporadasLessThanEqualAndEvaluacionGreaterThanEqual(Integer totalDeTemporadas,Double evaluacion);
    @Query(" Select s from Serie s where s.totalDeTemporadas<= :totalDeTemporadas and s.evaluacion>= :evaluacion")
    List<Serie> seriesPorTemporadaYEvaluacion(Integer totalDeTemporadas,Double evaluacion);
    @Query("select e from Serie s join s.episodios e where e.titulo ilike %:nombreEpisodio%")
    List<Episodio> episodiosPorNombre(String nombreEpisodio);
    @Query("select e from Serie s join s.episodios e where s= :serie ORDER BY e.evaluacion Desc limit 5")
    List<Episodio> top5Episodios(Serie serie);
    @Query("select s from Serie s " + "join s.episodios e " + "GROUP BY s " + " ORDER BY MAX(e.fechaDeLanzamiento) DESC LIMIT 5")
    List<Serie>lanzamientosMasRecientes();
    @Query("select e from Serie s JOIN s.episodios e WHERE s.id=:id and e.temporada=:numeroTemporada")
    List<Episodio> obtenerTemporadasPorNumero(Long id, Long numeroTemporada);
}
