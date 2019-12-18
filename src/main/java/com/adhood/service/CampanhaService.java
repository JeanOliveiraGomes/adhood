package com.adhood.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adhood.entity.Campanha;
import com.adhood.entity.Cliente;
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
	
}
