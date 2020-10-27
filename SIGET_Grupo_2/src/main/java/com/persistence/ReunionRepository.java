package com.persistence;

import org.springframework.stereotype.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.model.Reunion;

@Repository
public interface ReunionRepository extends MongoRepository<Reunion, String> {
	Optional<Reunion> findOneByAsistentes(String asistentes);
}
