package com.adhood.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adhood.entity.Campanha;
import com.adhood.entity.Cliente;
import com.adhood.service.CampanhaService;
import com.adhood.service.ClienteService;

@RestController
@RequestMapping(AdminPathBase.CAMPANHA )
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CampanhaController {
	
	@Autowired
	CampanhaService campanhaService;
	
	@PostMapping
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	public Campanha salvar(@RequestBody Campanha cliente) {
		return campanhaService.save(cliente);
	}
	
	@GetMapping
	@PreAuthorize("hasAnyAuthority('ADMIN','OPERADOR')")
	public Iterable<Campanha> findAll() {
		return campanhaService.findAll();
	}
	
	@GetMapping("/delete")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	public void delete(@RequestParam("id") Long id) {
		campanhaService.delete(id);
	}
	
	@GetMapping("/findByNome")
	@PreAuthorize("hasAnyAuthority('ADMIN','OPERADOR')")
	public List<Campanha> findByNome(@RequestParam("nome") String nome) {
		return campanhaService.findByNome(nome);
	}
	
}
