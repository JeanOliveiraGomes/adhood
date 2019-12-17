package com.adhood.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adhood.entity.Cliente;
import com.adhood.service.ClienteService;

@RestController
@RequestMapping(AdminPathBase.CLIENTE )
@CrossOrigin(origins = "*")
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	@PostMapping
	public Cliente salvar(@RequestBody Cliente cliente) {
		return clienteService.save(cliente);
	}
}
