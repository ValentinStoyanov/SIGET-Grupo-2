package com.persistence;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.model.Calendario;

@Repository
public interface CalendarioRepository extends MongoRepository<Calendario, String>{
	
	Optional<Calendario> findByHorainicio(String horainicio);
	
	Optional<Calendario> deleteByHorainicio(String horainicio);
}
