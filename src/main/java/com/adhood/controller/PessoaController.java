package com.adhood.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adhood.dtos.PessoaDTO;
import com.adhood.service.CustomUseDetailsManager;
import com.adhood.service.PessoaService;

import io.swagger.annotations.ApiOperation;

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
	@ApiOperation(value = "Retorna uma lista de pessoas pelo nome")
	public ResponseEntity<List<PessoaDTO>> findByNome(@RequestParam("nome") String nome) {
		return ResponseEntity.ok(pessoaService.findByNome(nome));
	}
	
	@GetMapping
	@PreAuthorize("hasAnyAuthority('ADMIN','OPERADOR')")
	@ApiOperation(value = "Retorna uma lista de pessoas")
	public ResponseEntity<List<PessoaDTO>>findAll() {
		return ResponseEntity.ok(pessoaService.findAll());
	}
	
	@PostMapping
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	@ApiOperation(value = "Salva uma pessoa")
	public PessoaDTO salvar(@RequestBody PessoaDTO pessoa) {
		return pessoaService.save(pessoa);
	}
	
	@PutMapping
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	@ApiOperation(value = "Altera uma pessoa")
	public PessoaDTO update(@RequestBody PessoaDTO pessoa) {
		return pessoaService.save(pessoa);
	}
	
	@DeleteMapping("/delete")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	@ApiOperation(value = "Deleta uma pessoa")
	public void delete(@RequestParam("id") Long id) {
		pessoaService.delete(id);
	}
}
