package com.adhood.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/source")
@CrossOrigin(origins = "*")
public class SourcesController {
	
	@GetMapping
	public String getcodigofonte() {
		return "<html>Link para <a href='https://github.com/JeanOliveiraGomes/adhood'>BackEnd</a> Link para <a href='https://github.com/JeanOliveiraGomes/adFront'>FrontEnd</a><html>";
	}

}
