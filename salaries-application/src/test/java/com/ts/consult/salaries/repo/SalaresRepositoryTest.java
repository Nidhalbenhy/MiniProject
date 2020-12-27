package com.ts.consult.salaries.repo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.ts.consult.salaries.model.Salaries;
import com.ts.consult.salaries.repository.SalariesRepository;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class SalaresRepositoryTest {
	
	
	@Autowired
	private SalariesRepository salariesRepository;
	
	
	
	@Test
	public void testCreateSalaries() {
		Salaries salaries = new Salaries("Nidahl002", "Bnhy", "Nid", new Date(), "Sartrouville");
		salariesRepository.save(salaries);
	}
	
	/**
	 * Tester la méthode ajouter utilisateur de la couche repository avec les
	 * propriétés firstName et lastName
	 */
	
	@Test
	public void testAddSalarieWithFieldOrProperty() {
		Salaries salarie = getSalaries();
		Salaries addedSalarie = salariesRepository.save(salarie) ;

		/**
		 * Vérification de l'ajout d'un utilisateur à travers son nom et son prénom
		 */
		assertThat(addedSalarie).hasFieldOrPropertyWithValue("nom", "Adam");
		assertThat(addedSalarie).hasFieldOrPropertyWithValue("prenom", "Slim");

	}
	
	

	/**
	 * Tester la méthode findAll de la couche repository
	 */
	@Test
	public void testGetAllSalaries() {
		Salaries sal1 = new Salaries();
		sal1.setMatricule("sal001");
		sal1.setNom("Adam");
		sal1.setPrenom("Slim");
		sal1.setDateNaissance(new Date());
		sal1.setAdresse("Adresse");
		Salaries sal2 = new Salaries();
		sal2.setMatricule("sal001");
		sal2.setNom("bhy");
		sal2.setPrenom("sami");
		sal2.setDateNaissance(new Date());
		sal2.setAdresse("Adresse2");
		salariesRepository.save(sal1) ;
		salariesRepository.save(sal2) ;

		Iterable<Salaries> allSalriesFromDb = salariesRepository.findAll();
		List<Salaries> salariesList = new ArrayList<>();

		for (Salaries salarie : allSalriesFromDb) {
			salariesList.add(salarie);
		}
		/**
		 * Vérifier si la méthode findAll() retourne deux salaries
		 */
		assertThat(salariesList.size()).isEqualTo(4);
	}
	
	
	
	private Salaries getSalaries() {
		Salaries s = new Salaries();
		s.setMatricule("sal001");
		s.setNom("Adam");
		s.setPrenom("Slim");
		s.setDateNaissance(new Date());
		s.setAdresse("Adresse");
		return s;
	}
	

	

}
