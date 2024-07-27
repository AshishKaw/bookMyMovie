package com.theatre.booking.bookMyMovie.util;

import org.springframework.data.jpa.domain.Specification;
import com.theatre.booking.bookMyMovie.dto.FilterCriteria;
import com.theatre.booking.bookMyMovie.entity.Shows;
import java.util.List;

import java.util.LinkedList;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class FilterSepcification implements Specification<Shows>{
	
	private FilterCriteria filterCriteria;
	public FilterSepcification(FilterCriteria filterCriteria){
		this.filterCriteria = filterCriteria;
	}
	
	@Override
	public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder criteriaBuilder) {
	
		List<Predicate> predicates = new LinkedList<>();
		
		if(filterCriteria.getCity()!=null && !filterCriteria.getCity().isBlank()) {
			predicates.add(criteriaBuilder.equal( root.get("screen").get("theatre").get("city"),filterCriteria.getCity().toLowerCase()));
		}
		
		if(filterCriteria.getGenres()!=null && !filterCriteria.getGenres().isBlank()) {
			predicates.add(criteriaBuilder.equal(criteriaBuilder.lower(root.get("genres")),filterCriteria.getGenres().toLowerCase()));
		}
		
		if(filterCriteria.getDirector()!=null && !filterCriteria.getDirector().isBlank()) {
			predicates.add(criteriaBuilder.equal(criteriaBuilder.lower(root.get("director")),filterCriteria.getDirector().toLowerCase()));
		}
		
		if(filterCriteria.getLanguage()!=null && !filterCriteria.getLanguage().isBlank()) {
			predicates.add(criteriaBuilder.equal(criteriaBuilder.lower(root.get("language")),filterCriteria.getLanguage().toLowerCase()));
		}
		if(filterCriteria.getName()!=null && !filterCriteria.getName().isBlank()) {
			predicates.add(criteriaBuilder.equal(criteriaBuilder.lower(root.get("name")),filterCriteria.getName().toLowerCase()));
		}
		
		if(filterCriteria.getDate()!=null) {
			predicates.add(criteriaBuilder.equal(root.get("date"), filterCriteria.getDate()));
		}
		
		return query.where(criteriaBuilder.and(predicates.toArray(new Predicate[0]))).orderBy(criteriaBuilder.desc(root.get("rating"))).getRestriction();
	}

}
