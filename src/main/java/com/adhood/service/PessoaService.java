package com.adhood.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.adhood.entity.Pessoa;
import com.adhood.repository.PessoalRepository;

public class PessoaService {
	
	@Autowired PessoalRepository pessoaRepository;

	public Pessoa salvarPessoa() {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("teste");
		return pessoaRepository.save(pessoa);
	}
}
