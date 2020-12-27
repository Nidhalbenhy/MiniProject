package com.ts.consult.salaries.specification;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.ts.consult.salaries.criteria.SalariesCriteria;
import com.ts.consult.salaries.model.Salaries;



public class SalariesSpecification implements Specification<Salaries> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SalariesCriteria salarieCriteria;
	
	
	
	public SalariesSpecification(SalariesCriteria salarieCriteria) {
		super();
		this.salarieCriteria = salarieCriteria;
	}



	@Override
	public Predicate toPredicate(Root<Salaries> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		Predicate predicate = criteriaBuilder.conjunction();
		List<Expression<Boolean>> expressions = predicate.getExpressions();
		if ((salarieCriteria.getNom() == null
				|| salarieCriteria.getNom()== "") 
				
				
				) {
			return predicate;
		}
		
	

		if (salarieCriteria.getNom() != null) {

			expressions.add(criteriaBuilder.like(root.get("nom"),
					"%" + salarieCriteria.getNom() +"%"));

		}
		

		
		return predicate;
	}



	
	}





