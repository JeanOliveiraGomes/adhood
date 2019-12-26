package com.adhood.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adhood.entity.Cliente;
import com.adhood.entity.Pessoa;
import com.adhood.service.ClienteService;

@RestController
@RequestMapping(AdminPathBase.CLIENTE )
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	@PostMapping
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	public Cliente salvar(@RequestBody Cliente cliente) {
		return clienteService.save(cliente);
	}
	
	@GetMapping
	public Iterable<Cliente> findAll() {
		return clienteService.findAll();
	}
	
	@GetMapping("/delete")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	public void delete(@RequestParam("id") Long id) {
		clienteService.delete(id);
	}
	
	@GetMapping("/findByNome")
	@PreAuthorize("hasAnyAuthority('ADMIN','OPERADOR')")
	public List<Cliente> findByNome(@RequestParam("nome") String nome) {
		return clienteService.findByNome(nome);
	}
}
