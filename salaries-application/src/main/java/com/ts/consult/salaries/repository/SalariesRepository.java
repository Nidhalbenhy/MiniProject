package com.ts.consult.salaries.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ts.consult.salaries.model.Salaries;

@Repository
public interface SalariesRepository extends MongoRepository<Salaries, String> {

	List<Salaries> findByNom(@Param("nom") String nom);
	Salaries findByMatricule(String matricule); 
}
