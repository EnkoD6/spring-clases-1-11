package com.example.obspringdatapa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ObSpringdatapaApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(ObSpringdatapaApplication.class, args);

		CocheRepository repository = context.getBean(CocheRepository.class);

		System.out.println("El numero de coches en base de datos es: " + repository.count());

		// crear y almacenar un coche en base de datos
		Coche toyota = new Coche(1L, "Toyota", "Prius", 2010);
		repository.save(toyota);

		System.out.println("El numero de coches en base de datos es: " + repository.count());

		// recuperar un coche por id

		System.out.println(repository.findAll());


	}

}
