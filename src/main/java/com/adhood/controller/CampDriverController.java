package com.adhood.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adhood.entity.CampDriver;
import com.adhood.service.CampDriverService;

@RestController
@RequestMapping(AdminPathBase.CAMPDRIVER )
@CrossOrigin(origins = "*")
public class CampDriverController {
	
	@Autowired
	CampDriverService campDriverService;
	
	@GetMapping
	@PreAuthorize("hasAnyAuthority('ADMIN','OPERADOR')")
	public Iterable<CampDriver> findAll() {
		return campDriverService.findAll();
	}
	
	@PostMapping
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	public CampDriver salvar(@RequestBody CampDriver pessoa) {
		return campDriverService.save(pessoa);
	}
	
	@GetMapping("/delete")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	public void delete(@RequestParam("id") Long id) {
		campDriverService.delete(id);
	}
}
