package com.example.p1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.p1.domain.Categoria;
import com.example.p1.repositories.CategoriaRepository;

@SpringBootApplication
public class P1Application implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(P1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		Categoria cat1 = new Categoria(null, "Informaticá");
		Categoria cat2 = new Categoria(null, "Escritório");
		
	categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
	
	}

}
