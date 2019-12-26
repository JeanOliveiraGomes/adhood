package com.adhood.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adhood.entity.CampDriver;
import com.adhood.repository.CampDriverRepository;

@Service
public class CampDriverService {
	
	@Autowired
	CampDriverRepository campDriverRepository;
	
	public Iterable<CampDriver> findAll() {
		return campDriverRepository.findAll();
	}
	
	public CampDriver save(CampDriver campanha) {
		return campDriverRepository.save(campanha);
	}
	
	public void delete(Long id) {
		this.campDriverRepository.deleteById(id);
	}
}
