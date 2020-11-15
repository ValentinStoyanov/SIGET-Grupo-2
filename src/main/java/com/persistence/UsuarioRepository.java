package com.persistence;

import org.springframework.stereotype.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.model.Usuario;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {
	
	
	Optional<Usuario> findOneByUsername(String username);
}
