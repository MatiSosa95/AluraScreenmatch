package com.AluraCursos.ScreenMatch.Model;


import jakarta.persistence.*;

import java.util.List;
import java.util.OptionalDouble;
@Entity
@Table(name= "series")
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String titulo;
    private Integer totalDeTemporadas;
    private Double evaluacion;
    @Enumerated(EnumType.STRING)
    private Categoria genero;
    private String actores;
    private String poster;
    private String fechaDeLanzamiento;
    private String sinopsis;
    @OneToMany(mappedBy = "serie", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Episodio> episodios;

    public Serie() {
    }

    public Serie(DatosSeries datosSeries){
        this.titulo= datosSeries.titulo();
        this.totalDeTemporadas= datosSeries.totalDeTemporadas();
        this.evaluacion= OptionalDouble.of(Double.valueOf(datosSeries.evaluacion())).orElse(0);
        this.poster= datosSeries.poster();
        //Se crea en Enum un metodo donde le pasamos un string y este lo compara con los enum creados.
        //Luego aqui abajo, al tener 3 generos, se hace un split, lo cual al encontrar una coma lo divide y
        //luego trae el valor que esta en el espacio 0.
        //El trim sirve para que no traiga valores vacios
        this.genero= Categoria.fromString(datosSeries.genero().split(",")[0].trim());
        this.actores= datosSeries.actores();
        this.sinopsis= datosSeries.sinopsis();
        this.fechaDeLanzamiento= datosSeries.fechaDeLanzamiento();
    }

    @Override
    public String toString() {
        return  " genero= " + genero +
                " titulo='" + titulo + '\'' +
                ", totalDeTemporadas=" + totalDeTemporadas +
                ", evaluacion=" + evaluacion +
                ", actores='" + actores + '\'' +
                ", poster='" + poster + '\'' +
                ", fechaDeLanzamiento='" + fechaDeLanzamiento + '\'' +
                ", sinopsis='" + sinopsis + '\''+
                ", Episodios='" + episodios + '\'';
    }

    public List<Episodio> getEpisodios() {
        return episodios;
    }

    public void setEpisodios(List<Episodio> episodios) {
        episodios.forEach(e->e.setSerie(this));
        this.episodios = episodios;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getTotalDeTemporadas() {
        return totalDeTemporadas;
    }

    public void setTotalDeTemporadas(Integer totalDeTemporadas) {
        this.totalDeTemporadas = totalDeTemporadas;
    }

    public Double getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(Double evaluacion) {
        this.evaluacion = evaluacion;
    }

    public Categoria getGenero() {
        return genero;
    }

    public void setGenero(Categoria genero) {
        this.genero = genero;
    }

    public String getActores() {
        return actores;
    }

    public void setActores(String actores) {
        this.actores = actores;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getFechaDeLanzamiento() {
        return fechaDeLanzamiento;
    }

    public void setFechaDeLanzamiento(String fechaDeLanzamiento) {
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }


}
