package com.adhood;

import java.util.Objects;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.adhood.entity.Pessoa;
import com.adhood.service.CustomUseDetailsManager;

@SpringBootApplication
public class AdHoodApiApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(AdHoodApiApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(CustomUseDetailsManager pessoaService, PasswordEncoder passEncoder) {
		return args -> {
			initAdministrador(pessoaService,passEncoder);
		}; 
	}
	
	private void initAdministrador(CustomUseDetailsManager pessoaService, PasswordEncoder passEncode) {
		Pessoa pessoa = pessoaService.findByEmail("administrador@adhood.com");
		if (Objects.isNull(pessoa)) {
			pessoaService.salvarPessoa();
		}
	}

}
