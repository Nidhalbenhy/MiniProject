package com.ts.consult.salaries.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.ts.consult.salaries.criteria.SalariesCriteria;
import com.ts.consult.salaries.dto.SalariesDTO;
import com.ts.consult.salaries.mapper.SalariesMapper;
import com.ts.consult.salaries.model.Salaries;
import com.ts.consult.salaries.repository.SalariesRepository;
import com.ts.consult.salaries.specification.SalariesSpecification;

@Service
public class SalariesService {
	
	@Autowired
	   private MongoOperations mongoOperations;

	@Autowired
	public SalariesRepository salariesRepository;
	//Create salarie
	public Salaries saveSalaries(Salaries salarie) {
		return salariesRepository.save(salarie);
	}
	
	//findAll salaries;
	public List<Salaries> getAllSalaries() {
		return salariesRepository.findAll();
	}
	// get Salarie by matricule
	public Salaries getSalarieByMatricule(String matricule) {
		Salaries s = salariesRepository.findByMatricule(matricule);
		return s;
	}
	
//public Page<Salaries> findAllByCriteria(SalariesCriteria criteria, Pageable pageable) {
//		
//	SalariesSpecification spec = new SalariesSpecification(criteria);
//	return salariesRepository.findAll(spec, pageable);
//	}
	
	
	
	 public List<Salaries> findByName( String nom) {
	     List<Salaries> salaries = new ArrayList<>();
	     Query searchQuery = new Query();
	     searchQuery.addCriteria(Criteria.where("nom").regex(nom));
	     salaries = mongoOperations.find(searchQuery, Salaries.class);
	     return salaries;
	   }
	 
	 public boolean salarieIsExist(String clientId) {
			
			return salariesRepository.existsById(clientId);
					}
}

