package com.projects.petmanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PetManagementSystemApplication {

	public static void main(String[] args) {
		//System.setProperty("spring.config.location","application.properties");
		SpringApplication.run(PetManagementSystemApplication.class, args);
	}

}
