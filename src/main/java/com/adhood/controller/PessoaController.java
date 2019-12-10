package com.adhood.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class PessoaController {

	@GetMapping("/ola")
	public String imprimir() {
		return "ola";
	}
}
