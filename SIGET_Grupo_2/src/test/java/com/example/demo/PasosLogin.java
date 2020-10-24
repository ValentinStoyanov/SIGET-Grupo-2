package com.example.demo;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

public class PasosLogin extends SigetGrupo2ApplicationTest{
	
	@When("el servidor recibe la llamada POST \\/login")
	public void llamadaLogin() throws Throwable{
	    System.out.println("Entra al when");
	}
	 
	@Then("^el cliente recibe la respuesta de que el login es correcto$")
	public void respuestaLogin() throws Throwable {
		System.out.println("Entra al Then");
	}
}
