package com.adhood.service;

import org.springframework.beans.factory.annotation.Autowired;
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
}
