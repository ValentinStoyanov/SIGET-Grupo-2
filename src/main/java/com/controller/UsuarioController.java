
package com.controller;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.Usuario;
import com.persistence.UsuarioRepository;

import io.cucumber.messages.internal.com.google.common.io.Files;

@CrossOrigin()
@RestController
@RequestMapping("usuarios")
public class UsuarioController { 
	@Autowired
	private UsuarioRepository usuarioRepository;

	@PostMapping("login")
	public Usuario login(@RequestParam(name = "username") String username, @RequestParam(name = "password") char[] password) throws GeneralSecurityException{
		
		Usuario user = this.usuarioRepository.findOneByUsername(username).get();
		
		byte salt[] = user.getSalt();
		
		PBEKeySpec spec = new PBEKeySpec(password, salt, 1000, 64*8);
		SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1"); // we would like this to be "PBKDF2WithHmacSHA512" instead? What Provider implements it?
		byte[] hash = skf.generateSecret(spec).getEncoded();
		
		
		Usuario aux = null;
		
		if(Arrays.equals(hash, user.getHash())) {
			aux = user;
		}
		
		return aux;
		
	}
	
	@GetMapping("getAll")
    public List<Usuario> getAll(){
        
        return this.usuarioRepository.findAll();
    }
	@PostMapping("createUsuario")
	public Usuario createUsuario(@RequestParam(name = "username") String username,
			@RequestParam(name = "password") char[] password) throws GeneralSecurityException {
		
		
		SecureRandom random = new SecureRandom();
		byte salt[] = new byte[64*8]; // use salt size at least as long as hash
		random.nextBytes(salt);
		
		PBEKeySpec spec = new PBEKeySpec(password, salt, 1000, 64*8);
		SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1"); // we would like this to be "PBKDF2WithHmacSHA512" instead? What Provider implements it?
		byte[] hash = skf.generateSecret(spec).getEncoded();
		
		
		return this.usuarioRepository.insert(new Usuario(username, salt,hash,"3"));
	}
	
	
	
	/*@PostMapping("createAdmin")
	public Usuario createAdmin(@RequestParam(name = "username") String username,
			@RequestParam(name = "password") String password) {
		return this.usuarioRepository.insert(new Usuario(username, password,"1"));
	}*/
	
	
	
}
