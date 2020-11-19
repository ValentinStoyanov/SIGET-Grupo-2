package com.example.demo;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.springframework.beans.factory.annotation.Autowired;

import com.model.Reunion;
import com.model.Usuario;
import com.persistence.ReunionRepository;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PasosRegistro {

	@Autowired
	private ReunionRepository usuarioRepository;
	private Usuario usuario;
	private Usuario usuarioAlmacenado;
	
	@Given("se registra al usuario con {string}, {string}, {string}, {string}, {string}, {string} y {string}")
	public void se_registra_al_usuario_con_y(String username, String password, String roleID, String nombre, String apellidos, String email, String telefono) throws NoSuchAlgorithmException, InvalidKeySpecException {
		/*
		SecureRandom random = new SecureRandom();
		byte salt[] = new byte[64*8]; // use salt size at least as long as hash
		random.nextBytes(salt);
		char[] pass = password.toCharArray();
		
		PBEKeySpec spec = new PBEKeySpec(pass, salt, 1000, 64*8);
		SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1"); 
		byte[] hash = skf.generateSecret(spec).getEncoded();
		this.usuarioRepository.insert(new Usuario(username, salt,hash,"3",nombre,apellidos,email,telefono));
		*/
		
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
