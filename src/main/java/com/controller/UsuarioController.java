
package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.Reunion;
import com.model.Usuario;
import com.persistence.UsuarioRepository;

@CrossOrigin()
@RestController
@RequestMapping("usuarios")
public class UsuarioController { 
	@Autowired
	private UsuarioRepository usuarioRepository;

	@PostMapping("login")
	public boolean login(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password){
		if(!this.usuarioRepository.findOneByUsernameAndPassword(username, password).equals(null)) {
			return true;
		}
		return false;
	}
	
	@GetMapping("getAll")
    public List<Usuario> getAll(){
        List<Usuario> r = this.usuarioRepository.findAll();
        return r;
    }
	
	
}
