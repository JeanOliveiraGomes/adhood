package com.adhood;

import java.util.Objects;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.adhood.configuracoes.security.AuditorAwareImpl;
import com.adhood.entity.Pessoa;
import com.adhood.enums.PerfilEnum;
import com.adhood.service.CustomUseDetailsManager;

@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@SpringBootApplication
public class AdHoodApiApplication {
	
	@Bean
	public AuditorAware<String> auditorAware() {
		return new AuditorAwareImpl();
	}
	
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
		Pessoa administrador = pessoaService.findByEmail("administrador@adhood.com");
		if (Objects.isNull(administrador)) {
			pessoaService.salvarPessoa("administrador@adhood.com", PerfilEnum.ADMIN);
		}
		Pessoa operador = pessoaService.findByEmail("operador@adhood.com");
		if (Objects.isNull(operador)) {
			pessoaService.salvarPessoa("operador@adhood.com", PerfilEnum.OPERADOR);
		}
	}

}
