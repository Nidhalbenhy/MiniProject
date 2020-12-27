package com.ts.consult.salaries.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ts.consult.salaries.criteria.SalariesCriteria;
import com.ts.consult.salaries.model.Salaries;
import com.ts.consult.salaries.service.SalariesService;
import com.ts.consult.salaries.util.PaginationUtil;

@RestController
@CrossOrigin(origins ="*")
@RequestMapping("/salaries")
public class salariesController {
	
	@Autowired
	public SalariesService salariesService;
	
	@PostMapping("/saveSalaries")
	public ResponseEntity<Salaries> createSalaries(@RequestBody Salaries salaries) {
		
		Salaries salarie = salariesService.saveSalaries(salaries);
		return new ResponseEntity<Salaries>(salarie, HttpStatus.OK);

		
	}
	@GetMapping("/allSalaries")
	public ResponseEntity<List<Salaries>> findAllSalaries() {
		List<Salaries> salarie= salariesService.getAllSalaries();
		System.out.println("aaaaammmmmmmmmmmmmmmm" + salarie);
		if(salarie.isEmpty()) {return new ResponseEntity(HttpStatus.NO_CONTENT);}
	
		return new ResponseEntity<List<Salaries>>(salarie,HttpStatus.OK);
	}
	
//	 @PostMapping("/query")
//		public ResponseEntity<List<Salaries>> query(@RequestBody SalariesCriteria criteria,
//				@PageableDefault(size = 10000) Pageable pageable) {
//
//			Page<Salaries> page = salariesService.findAllByCriteria(criteria, pageable);
//			HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/salaries");
//			return ResponseEntity.ok().headers(headers)
//					.body(page.getContent().stream().distinct().collect(Collectors.toList()));
//		}
	
	@RequestMapping(path = "/query", method = RequestMethod.GET)
	   public List<Salaries> findName(@RequestParam("nom") String nom) {
	        
	      return salariesService.findByName(nom);
	        
	   }
	
	@GetMapping("/isMatriculeExist/")
	public Boolean testMatricule( @RequestParam(value="matricule") String matricule) {
		Salaries salarie = salariesService.getSalarieByMatricule(matricule);
		if(salarie!=null) {
			return true;
		}
		return false;
	}

}
