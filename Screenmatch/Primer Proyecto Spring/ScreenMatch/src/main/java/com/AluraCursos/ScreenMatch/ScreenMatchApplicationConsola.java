//package com.AluraCursos.ScreenMatch;
//
//import com.AluraCursos.ScreenMatch.Repository.SerieRepository;
//import com.AluraCursos.ScreenMatch.principal.Principal;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class ScreenMatchApplicationConsola implements CommandLineRunner {
//
//	@Autowired
//	private SerieRepository serieRepository;
//
//	public static void main(String[] args) {
//		SpringApplication.run(ScreenMatchApplicationConsola.class, args);
//	}
//
//	@Override
//	public void run(String... args) throws Exception {
//		Principal principal= new Principal(serieRepository);
//		principal.muestraElMenu();
////		EjemplosStreams ejemplosStreams= new EjemplosStreams();
////		ejemplosStreams.muestraEjemplo();
//	}
//}