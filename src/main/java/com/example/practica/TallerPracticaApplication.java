package com.example.practica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class TallerPracticaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TallerPracticaApplication.class, args);
	}

}
