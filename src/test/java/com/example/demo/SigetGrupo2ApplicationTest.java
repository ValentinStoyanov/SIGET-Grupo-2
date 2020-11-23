package com.example.demo;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest
public class SigetGrupo2ApplicationTest {
	
	@Test
	public void helloWorld() {
		System.out.println("Hola");
	}

}


