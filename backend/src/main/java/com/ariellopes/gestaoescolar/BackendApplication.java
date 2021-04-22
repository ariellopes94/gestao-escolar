package com.ariellopes.gestaoescolar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ariellopes.gestaoescolar.rest.services.DBService;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}	
	
	@Autowired
	private DBService dbService;
	
	@Override
	public void run(String... args) throws Exception {
		dbService.instantiateTestDatabase();
		
		
	}

}
