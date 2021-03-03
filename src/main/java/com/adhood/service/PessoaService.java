package com.adhood.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.adhood.dtos.PessoaDTO;
import com.adhood.entity.Pessoa;
import com.adhood.mapping.PessoaMapping;
import com.adhood.repository.PessoalRepository;
import com.adhood.util.ValidaCPF;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PessoaService {
	
	private final PessoalRepository pessoaRepository;
	
    private final PasswordEncoder passwordEncoder;
    
    private final PessoaMapping pessoaMapping;
	
	public List<PessoaDTO> findByNome(String nome){
		List<PessoaDTO> pessoasDTO = new ArrayList<>(); 
		Pageable pageable = PageRequest.of(0, 10, Sort.Direction.DESC, "nome");
		List<Pessoa> pessoas = pessoaRepository.findByNomeContainingIgnoreCase(nome, pageable);
		pessoas.forEach(d -> {
			pessoasDTO.add(pessoaMapping.entidadeParaDTO(d));
		});
		return pessoasDTO;
	}
	
	public PessoaDTO save(PessoaDTO pessoaDTO) {
		Pessoa pessoa = pessoaMapping.dtoParaEntidade(pessoaDTO);
		if (!ValidaCPF.isCPF(pessoa.getCpf())) {
			throw new IllegalArgumentException("CPF invalido.");
		}
		if (Objects.nonNull(pessoa.getPassword()) && !pessoa.getPassword().equals("")) {			
			pessoa.setPassword(passwordEncoder.encode(pessoa.getPassword()));			
		}else if(Objects.nonNull(pessoa.getId())){
			Pessoa pessoaAtual = pessoaRepository.findById(pessoa.getId()).orElse(null);
			if (Objects.nonNull(pessoaAtual)) {
				pessoa.setPassword(Objects.nonNull(pessoaAtual.getPassword())? pessoaAtual.getPassword() : passwordEncoder.encode("123"));				
			}
		}
		pessoa.setAccountNonExpired(true);
		pessoa.setAccountNonLocked(true);
		pessoa.setEnabled(true);
		pessoa.setCredentialsNonExpired(true);
		return pessoaMapping.entidadeParaDTO(pessoaRepository.save(pessoa));
	}
	
	public List<PessoaDTO> findAll() {
		List<PessoaDTO> pessoasDTO = new ArrayList<>(); 
		List<Pessoa> pessoas = pessoaRepository.findAll();
		pessoas.forEach(d -> {
			pessoasDTO.add(pessoaMapping.entidadeParaDTO(d));
		});
		return pessoasDTO;
	}
	
	public void delete(Long id) {
		this.pessoaRepository.deleteById(id);
	}
}
