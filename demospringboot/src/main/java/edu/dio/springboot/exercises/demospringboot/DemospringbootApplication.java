package edu.dio.springboot.exercises.demospringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.dio.springboot.exercises.demospringboot.Model.GameCollection;

@SpringBootApplication
public class DemospringbootApplication {
	@Autowired
	GameCollection gameCollection;

	public static void main(String[] args) {
		SpringApplication.run(DemospringbootApplication.class, args);
	}

	
}
