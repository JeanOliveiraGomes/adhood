package com.adhood.service;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.adhood.entity.Pessoa;
import com.adhood.repository.PessoalRepository;

@Service
public class PessoaService {
	
	@Autowired
	PessoalRepository pessoaRepository;
	
	public List<Pessoa> findByNome(String nome){
		Pageable pageable = PageRequest.of(0, 10, Sort.Direction.DESC, "nome");
		return pessoaRepository.findByNomeContainingIgnoreCase(nome, pageable);
	}
}
