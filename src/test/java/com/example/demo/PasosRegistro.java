package com.example.demo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PasosRegistro {
	@Given("se registra al usuario con {string}, {string}, {string}, {string}, {string} y {string}")
	public void se_registra_al_usuario_con_y(String username, String roleID, String nombre, String apellidos, String email, String telefono) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("se recupera el usuario registrado de la base de datos")
	public void se_recupera_el_usuario_registrado_de_la_base_de_datos() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("los datos introducidos y los recuperados del registro coinciden")
	public void los_datos_introducidos_y_los_recuperados_del_registro_coinciden() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
}
