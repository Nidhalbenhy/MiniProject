package com.ts.consult.salaries.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ts.consult.salaries.model.Salaries;
import com.ts.consult.salaries.repository.SalariesRepository;
import com.ts.consult.salaries.service.SalariesService;




@RunWith(SpringRunner.class)
@WebMvcTest(salariesController.class)
@AutoConfigureMockMvc
@ContextConfiguration(classes = AnnotationConfigContextLoader.class)
public class SalariesControllerTest {
	
	private final String SALARIES_ID =  "01";

	@Autowired
	private MockMvc mock;
	@InjectMocks
	private salariesController salController;
	
	private Salaries salarie;
	
	@Mock
	private SalariesRepository salariesRepository;
	
	@Mock
	private SalariesService salariesService;
	
	
	@Before
	public void setup() {
		
		MockitoAnnotations.initMocks(this);
		
		mock = MockMvcBuilders.standaloneSetup(salController).build();
		
		salarie = new Salaries("SALARIE_ID");
		salarie.setMatricule("sal001");
		salarie.setNom("Adam");
		salarie.setPrenom("Slim");
		salarie.setDateNaissance(new Date());
		salarie.setAdresse("Adresse");
		System.out.println("aaaaaaaaaaaa "+salarie);
		
	}
	
	/**
	 * Test method findAllSalaries
	 * 
	 * @throws Exception
	 */
	@Test
	public void findAllSalariesTest() throws Exception {
		List<Salaries> salaries = new ArrayList<>();
		salaries.add(salarie);
		when((List<Salaries>)salariesService.getAllSalaries()).thenReturn(salaries);
		
		mock.perform(MockMvcRequestBuilders.get("/salaries/allSalaries")
		.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}
	
	/**
	 * Test method CreateSalarie
	 * 
	 * @throws Exception
	 */
	
	
	@Test
	public void createSalarieTest() throws Exception {
		
		when(salariesService.salarieIsExist(salarie.getId())).thenReturn(false);
		
		mock.perform(MockMvcRequestBuilders.post("/salaries/saveSalaries").accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).content(asJsonString(salarie)))
		.andExpect(status().isOk());
		
	}
	
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


}
