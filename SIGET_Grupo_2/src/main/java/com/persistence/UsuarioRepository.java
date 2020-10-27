package com.persistence;

import org.springframework.stereotype.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.model.Usuario;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {
	Optional<Usuario> findOneByUsernameAndPassword(String username, String password);
}
