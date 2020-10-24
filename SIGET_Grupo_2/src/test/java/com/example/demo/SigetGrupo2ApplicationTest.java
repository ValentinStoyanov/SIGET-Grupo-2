package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest
public class SigetGrupo2ApplicationTest {

	@Test
	public void testeoJunit() {
		System.out.println("Entra al test");
	}
}
