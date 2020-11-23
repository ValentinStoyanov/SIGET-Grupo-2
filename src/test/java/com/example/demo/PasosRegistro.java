package com.example.demo;

import static org.junit.Assert.fail;

import java.security.SecureRandom;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.springframework.beans.factory.annotation.Autowired;

import com.model.Usuario;
import com.persistence.UsuarioRepository;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PasosRegistro {

	@Autowired
	private UsuarioRepository usuarioRepository;
	private Usuario usuario;
	private Usuario usuarioAlmacenado;
	
	@Given("se registra al usuario con {string}, {string} {string}, {string}, {string}, {string} y {string}")
	public void se_registra_al_usuario_con_y(String username, String password, String roleID, String nombre, String apellidos, String email, String telefono) {
		SecureRandom random = new SecureRandom();
		byte salt[] = new byte[64*8]; // use salt size at least as long as hash
		random.nextBytes(salt);
		char[] pass = password.toCharArray();
		byte[] hash = null;
		
		PBEKeySpec spec = new PBEKeySpec(pass, salt, 1000, 64*8);
		SecretKeyFactory skf;
		try {
			skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			hash = skf.generateSecret(spec).getEncoded();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		this.usuario = new Usuario(username, salt,hash,"3",nombre,apellidos,email,Integer.parseInt(telefono));
	}
	@When("se recupera el usuario registrado de la base de datos")
	public void se_recupera_el_usuario_registrado_de_la_base_de_datos() {
		this.usuarioAlmacenado = this.usuarioRepository.insert(this.usuario);
	}
	@Then("los datos introducidos y los recuperados del registro coinciden")
	public void los_datos_introducidos_y_los_recuperados_del_registro_coinciden() {
		if(!(this.usuario.getUsername().equals(this.usuarioAlmacenado.getUsername())
		    	&& this.usuario.getSalt().equals(this.usuarioAlmacenado.getSalt())
		    	&& this.usuario.getHash().equals(this.usuarioAlmacenado.getHash())
		    	&& this.usuario.getNombre().equals(this.usuarioAlmacenado.getNombre())
		    	&& this.usuario.getApellidos().equals(this.usuarioAlmacenado.getApellidos())
		    	&& this.usuario.getEmail().equals(this.usuarioAlmacenado.getEmail())
		    	&& this.usuario.getTelefono() == this.usuarioAlmacenado.getTelefono()
		    )) {
			this.usuarioRepository.deleteByUsername(this.usuarioAlmacenado.getUsername());
		    	fail("El usuario introducido y recuperado no coinciden");
		    }
		    this.usuarioRepository.deleteByUsername(this.usuarioAlmacenado.getUsername());
	}
}
