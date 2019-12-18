package com.adhood.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adhood.entity.Campanha;

@Repository
public interface CampanhaRepository extends CrudRepository<Campanha, Long>{
	
}
