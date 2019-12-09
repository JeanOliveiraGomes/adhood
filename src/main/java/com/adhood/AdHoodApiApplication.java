package com.adhood;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.adhood.service.PessoaService;

@SpringBootApplication
public class AdHoodApiApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(AdHoodApiApplication.class, args);
	}

}
