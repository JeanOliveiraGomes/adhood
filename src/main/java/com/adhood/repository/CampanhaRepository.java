package com.adhood.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adhood.entity.Campanha;
@Repository
public interface CampanhaRepository extends CrudRepository<Campanha, Long>{
	List<Campanha> findByNomeContainingIgnoreCase(String nome, Pageable pegeable);
}
