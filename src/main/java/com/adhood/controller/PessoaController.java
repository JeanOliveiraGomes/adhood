package com.adhood.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adhood.service.CustomUseDetailsManager;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class PessoaController {

	
	@Autowired
	CustomUseDetailsManager custom;
	
	@GetMapping("/ola")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	public boolean imprimir() {
		return custom.userExists("email2");
	}
}
