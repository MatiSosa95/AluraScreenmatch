package com.AluraCursos.ScreenMatch.principal;

import java.util.Arrays;
import java.util.List;

public class EjemplosStreams {

    public void muestraEjemplo(){
        List<String> nombres= Arrays.asList("Brenda", "Genesis", "Matias", "Fernanda");

        nombres.stream()
                .sorted()
                .limit(4)
                .filter(n->n.startsWith("M"))
                .map(n->n.toUpperCase())
                .forEach(System.out::println);
    }
}
