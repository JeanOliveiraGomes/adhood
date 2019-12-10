package com.adhood.configuracoes;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.adhood.service.PessoaService;

@Configuration
public class ProjetoConfiguracoes extends WebSecurityConfigurerAdapter{

	@Bean
	public PasswordEncode passwordEnconder() {
		return new PasswordEncode();
	}
	
	@Bean(name = "pessoaS")
	public PessoaService pessoaService() {
		PessoaService pessoaService = new PessoaService();
		return pessoaService;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic();
		http.authorizeRequests().anyRequest().permitAll();
	}

	
	
}
