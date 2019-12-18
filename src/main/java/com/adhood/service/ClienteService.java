package com.adhood.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.adhood.entity.Cliente;
import com.adhood.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente save(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public Iterable<Cliente> findAll(){
		return this.clienteRepository.findAll();
	}
	
	public void delete(Long id) {
		this.clienteRepository.deleteById(id);
	}
	
	public List<Cliente> findByNome(String nome){
		Pageable pageable = PageRequest.of(0, 10, Sort.Direction.DESC, "nome");
		return clienteRepository.findByNomeContainingIgnoreCase(nome, pageable);
	}
}
