package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan("com.controller")
@EnableMongoRepositories("com.persistence")
public class SigetGrupo2Application {

	public static void main(String[] args) {
		SpringApplication.run(SigetGrupo2Application.class, args);
	}

}
