package com.adhood.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adhood.entity.Pessoa;
import com.adhood.service.CustomUseDetailsManager;
import com.adhood.service.PessoaService;

@RestController
@RequestMapping(AdminPathBase.PESSOA )
@CrossOrigin(origins = "*")
public class PessoaController {

	
	@Autowired
	CustomUseDetailsManager custom;
	
	@Autowired
	PessoaService pessoaService;
	
	@GetMapping("/findByNome")
	@PreAuthorize("hasAnyAuthority('ADMIN','OPERADOR')")
	public List<Pessoa> findByNome(@RequestParam("nome") String nome) {
		return pessoaService.findByNome(nome);
	}
}
