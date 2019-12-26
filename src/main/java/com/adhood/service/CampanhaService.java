package com.adhood.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.adhood.entity.Campanha;
import com.adhood.repository.CampanhaRepository;

@Service
public class CampanhaService {

	@Autowired
	CampanhaRepository campanhaRepository;
	
	public Iterable<Campanha> findAll() {
		return campanhaRepository.findAll();
	}
	
	public Campanha save(Campanha campanha) {
		return campanhaRepository.save(campanha);
	}
	
	public void delete(Long id) {
		this.campanhaRepository.deleteById(id);
	}
	
	public List<Campanha> findByNome(String nome){
		Pageable pageable = PageRequest.of(0, 10, Sort.Direction.DESC, "nome");
		return campanhaRepository.findByNomeContainingIgnoreCase(nome, pageable);
	}
	
}
