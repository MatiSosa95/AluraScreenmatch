package com.AluraCursos.ScreenMatch.principal;

import com.AluraCursos.ScreenMatch.Model.*;
import com.AluraCursos.ScreenMatch.Repository.SerieRepository;
import com.AluraCursos.ScreenMatch.Services.ConsumoAPI;
import com.AluraCursos.ScreenMatch.Services.ConvierteDatos;

import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    private Scanner sc= new Scanner(System.in);
    private ConsumoAPI consumoAPI= new ConsumoAPI();
    private final String URL_BASE="https://www.omdbapi.com/?t=";
    private final String API_KEY="&apikey=ed55fe03" ;
    private ConvierteDatos conversor= new ConvierteDatos();
    private List<DatosSeries> datosSeries= new ArrayList<>();
    private SerieRepository repositorio;
    private List<Serie> series;
    Optional<Serie> serieBuscada;

    public Principal(SerieRepository repository){
    this.repositorio= repository;
    }

    public void muestraElMenu(){

        var option= -1;
        while (option!=0){
            var menu= """
                    1-Buscar Series
                    2-Buscar Episodios
                    3-Mostrar series Buscadas
                    4-Buscas Serie por titulo 
                    5-Top 5 mejores series
                    6-Buscar serie por categoria
                    7-Buscar Serie por cantidad de temporadas
                    8-Buscar episodios por titulo
                    9-Top 5 mejores episodios por serie
                    10-borrar la base de datos
                    0-Salir""";
            System.out.println(menu);
            option= sc.nextInt();
            sc.nextLine();

            switch (option){
                case 1:
                    buscarSerieWeb();
                    break;
                case 2: buscarEpisodiosPorSerie();
                    break;
                case 3:
                    mostrarSeriesBuscadas();
                    break;
                case 4:
                    buscarSeriePorTitulo();
                    break;
                case 5:
                    buscarTop5Series();
                    break;
                case 6:
                    buscarseriesPorCategoria();
                    break;
                case 7:
                    filtrarSeriesPorTemporadaYEvaluacion();
                    break;
                case 8:
                    buscarEpisodiosPorTitulo();
                    break;
                case 9:
                    buscarTop5EpisodiosPorSerie();
                    break;
                case 10:
                    borrarBaseDeDatos();
                    break;
                case 0:
                    System.out.println("Cerrando Aplicacion...");
                    break;
                default:
                    System.out.println("Opcion Inválida");
            }
        }

//        System.out.println("Por favor ingrese el nombre de la serie que quieras buscar");
//        //Busca los datos generales de las series.
//        var NombreSerie= sc.nextLine();
//        var json=consumoAPI.obtenerDatos(URL_BASE  + NombreSerie.replace(" ","+") + API_KEY);
//        var datos= conversor.obtenerDatos(json, DatosSeries.class);
//        System.out.println(datos);

        //Busca los datos de todas las temporadas
//        List<DatosTemporadas> temporadas= new ArrayList<>();
//        for (int i = 1; i <= datos.totalDeTemporadas(); i++) {
//            //Ciclo for que nos permite obtener todos los datos de la temporada
//            json= consumoAPI.obtenerDatos(URL_BASE+NombreSerie.replace(" ","+")+ "&Season="+i+API_KEY);
//            var datosTemporadas= conversor.obtenerDatos(json, DatosTemporadas.class);
//            temporadas.add(datosTemporadas);
//        }

        //temporadas.forEach(System.out::println);

        //Mostrar solo el titulo de los episodios para las temporadas
//        for (int i = 0; i < datos.totalDeTemporadas(); i++) {
//            List<DatosEpisodio> episodiosTemporadas= temporadas.get(i).episodios();
//            for (int j = 0; j < episodiosTemporadas.size(); j++) {
//                System.out.println(episodiosTemporadas.get(j).titulo());
//            }
//        }

        //vamos a mejorar los dos for con un lamda
//        temporadas.forEach(t -> t.episodios().forEach(e-> System.out.println(e.titulo())));

        //Convertir todas las informaciones a una lista del tipo DatosEpisodio
//        List<DatosEpisodio> datosEpisodios= temporadas.stream()
//                .flatMap(t-> t.episodios().stream())
//                .collect(Collectors.toList());

        //Top 5 de episodios
//        System.out.println("Top 5 de Episodios");
//        datosEpisodios.stream()
//                .filter(e->!e.evaluacion().equalsIgnoreCase("N/A"))
//                .sorted(Comparator.comparing(DatosEpisodio::evaluacion).reversed())
//                .limit(5)
//                .forEach(System.out::println);



        //convirtiendo los datos a una lista del tipo episodio
//        List<Episodio> episodios= temporadas.stream()
//                .flatMap(t->t.episodios().stream()
//                    .map(d->new Episodio(t.numeroTemporada(),d)))
//                .collect(Collectors.toList());

        //pisodios.forEach(System.out::println);

        //Se busca episodios por la fecha o por año
//        System.out.println("Indica el año a partir del cual deseas ver los episodios");
//        var fecha= sc.nextInt();
//        sc.nextLine();
//
//        LocalDate fechaBusqueda= LocalDate.of(fecha, 1, 1);
//        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        episodios.stream()
//                .filter(e->e.getFechaDeLanzamiento() != null && e.getFechaDeLanzamiento().isAfter(fechaBusqueda))
//                .forEach(e-> System.out.println(
//                        "Temporada "+ e.getTemporada() +
//                                " Episodio " +e.getTitulo() +
//                                " Fecha de Lanzamiento " + e.getFechaDeLanzamiento().format(dtf)
//                ));

        //Transformamos lista de datos de episodios a lista de episodios y buscamos los 5 mejores episodios segun el año

//        System.out.println("Top 5 de episodios con lista de episodio");
//        episodios.stream()
//                .filter(e->!e.getEvaluacion().equals("N/A"))
//                //.peek(e-> System.out.println("primer filtro(N/A)"+e))
//                .sorted(Comparator.comparing(Episodio::getEvaluacion).reversed())
//                //.peek(e-> System.out.println("segundo filtro(M<m)"+e))
//                .map(e->e.getTitulo().toUpperCase())
//                //.peek(e-> System.out.println("tercer filtro mayusculas(m<M)"+e))
//                .limit(5)
//                .forEach(System.out::println);

        //Busca episodios por pedazo del titulo
//        System.out.println("Ingrese el titulo del episodio que desea buscar");
//
//        var pedazoTitulo= sc.nextLine();
//        Optional<Episodio> episodioBuscado = episodios.stream()
//                .filter(e -> e.getTitulo().toUpperCase().contains(pedazoTitulo.toUpperCase()))
//                .findAny();
//
//        if (episodioBuscado.isPresent()){
//            System.out.println("Episodio encontrado");
//            System.out.println("Los datos son: "+ episodioBuscado.get());
//        }else{
//            System.out.println("Episodio no encontrado");
//        }

        //mapa de datos de temporada
//        Map<Integer, Double>evaluacionPorTemporada= episodios.stream()
//                .filter(e->e.getEvaluacion()>0.0)
//                .collect(Collectors.groupingBy(Episodio::getTemporada,
//                        Collectors.averagingDouble(Episodio::getEvaluacion)));
//        System.out.println(evaluacionPorTemporada);
//        //Recolectando estadisticas
//        DoubleSummaryStatistics est= episodios.stream()
//                .filter(e->e.getEvaluacion()>0.0)
//                .collect(Collectors.summarizingDouble(Episodio::getEvaluacion));
//        System.out.println("La media de las evaluaciones es: "+ est.getAverage());
//        System.out.println("El episodio mejor evaluado  "+ est.getMax());
//        System.out.println("El episodio peor evaluado "+est.getMin());
    }

    private DatosSeries getDatosSeries(){
        System.out.println("Por favor ingrese el nombre de la serie que quieras buscar");
        //Busca los datos generales de las series.
        var NombreSerie= sc.nextLine();
        var json=consumoAPI.obtenerDatos(URL_BASE  + NombreSerie.replace(" ","+") + API_KEY);
        System.out.println(json);
        var datos= conversor.obtenerDatos(json, DatosSeries.class);
        return datos;
    }

    private void buscarEpisodiosPorSerie(){
        //DatosSeries datosSeries= getDatosSeries();
        mostrarSeriesBuscadas();
        System.out.println("Escribe el nombre de la serie de la cual  quieres ver los episodios");
        var nombreSerie= sc.nextLine();

        Optional<Serie> serie= series.stream()
                .filter(s->s.getTitulo().toLowerCase().contains(nombreSerie.toLowerCase()))
                .findFirst();

        if (serie.isPresent()){
            var serieEncontrada= serie.get();

            List<DatosTemporadas> temporadas= new ArrayList<>();

            for (int i = 1; i < serieEncontrada.getTotalDeTemporadas(); i++) {
                var json=consumoAPI.obtenerDatos(URL_BASE  + serieEncontrada.getTitulo().replace(" ","+")+ "&season=" + i  + API_KEY);
                DatosTemporadas datosTemporadas= conversor.obtenerDatos(json, DatosTemporadas.class);
                temporadas.add(datosTemporadas);
            }
            temporadas.forEach(System.out::println);

            List<Episodio> episodios=temporadas.stream()
                    .flatMap(d -> d.episodios().stream()
                            .map(e-> new Episodio(d.numeroTemporada(),e))).
                    collect(Collectors.toList());

            serieEncontrada.setEpisodios(episodios);
            repositorio.save(serieEncontrada);
        }



    }

    private void buscarSerieWeb(){
        DatosSeries datos= getDatosSeries();
        Serie serie= new Serie(datos);
        repositorio.save(serie);
       // datosSeries.add(datos);
        System.out.println(datos);
    }

    private void mostrarSeriesBuscadas(){
        series= repositorio.findAll();

        series.stream()
                .sorted(Comparator.comparing(Serie::getGenero))
                .forEach(System.out::println);
    }

    private void buscarSeriePorTitulo(){
        System.out.println("Escribe el nombre de la serie que deseas buscar");
        var nombreSerie= sc.nextLine();
       serieBuscada= repositorio.findByTituloContainsIgnoreCase(nombreSerie);

        if (serieBuscada.isPresent()){
            System.out.println("La serie buscada es: " + serieBuscada.get());
        }else{
            System.out.println("Serie no encontrada");
        }
    }

    private void buscarTop5Series(){
        List<Serie> topSeries= repositorio.findTop5ByOrderByEvaluacionDesc();
        topSeries.forEach(s-> System.out.println("Serie: "+ s.getTitulo()+ " Evaluacion: "+ s.getEvaluacion()));
    }

    private void buscarseriesPorCategoria(){
        System.out.println("Escriba el genero/categoria de la serie que desea buscar");
        var genero= sc.nextLine();
        var categoria= Categoria.formEspanol(genero);
        List<Serie> seriePorCategoria= repositorio.findByGenero(categoria);
        System.out.println("Las series de la categoria "+ genero );
        seriePorCategoria.forEach(System.out::println);
    }

    private void filtrarSeriesPorTemporadaYEvaluacion(){
        System.out.println("Filtrar series por cantidad de temporadas");
        var temporadasMax= sc.nextInt();
        System.out.println("¿Evaluar a partir de que valor?");
        var evaluacion= sc.nextDouble();

        List<Serie> filtroSeries= repositorio.seriesPorTemporadaYEvaluacion(temporadasMax, evaluacion);

        System.out.println("***Serie Filtradas***");
        filtroSeries.forEach(s-> System.out.println(s.getTitulo() + " - Evaluacion "+ s.getEvaluacion()));
    }

    private  void buscarEpisodiosPorTitulo(){
        System.out.println("Escribe el nombre del episodio que deseas buscar");
        var nombreEpisodio= sc.nextLine();

        List<Episodio> episodiosEncontrados= repositorio.episodiosPorNombre(nombreEpisodio);

        episodiosEncontrados.forEach(e-> System.out.printf("Serie: %s Temporada %s Episodio %s Evaluación %s \n", e.getSerie(), e.getTemporada(),e.getNumeroEpisodio(), e.getEvaluacion()));

    }

    private void buscarTop5EpisodiosPorSerie(){
        buscarSeriePorTitulo();
        if (serieBuscada.isPresent()){
            Serie serie= serieBuscada.get();
            List<Episodio> top5Episodios= repositorio.top5Episodios(serie);
            top5Episodios.forEach(e-> System.out.printf("Serie: %s Temporada %s Episodio %s Evaluación %s \n", e.getSerie(), e.getTemporada(),e.getTitulo(), e.getEvaluacion()));
        }

    }

    private void borrarBaseDeDatos(){
        repositorio.deleteAll();
    }
}
