package com.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.model.Calendario;

@Repository
public interface CalendarioRepository extends MongoRepository<Calendario, String>{

}
