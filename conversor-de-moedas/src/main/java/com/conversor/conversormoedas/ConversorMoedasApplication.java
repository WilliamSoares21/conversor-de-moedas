package com.conversor.conversormoedas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class ConversorMoedasApplication {

	public static void main(String[] args) {
		// Carrega o .env do diretório atual do projeto
		Dotenv dotenv = Dotenv.configure()
			.ignoreIfMissing()
			.load();
		
		// Define as variáveis como propriedades do sistema
		dotenv.entries().forEach(entry -> 
			System.setProperty(entry.getKey(), entry.getValue())
		);
		
		SpringApplication.run(ConversorMoedasApplication.class, args);
	}

}
