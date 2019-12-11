package com.adhood.configuracoes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.adhood.service.PessoaService;

@Configuration
public class ProjetoConfiguracoes extends WebSecurityConfigurerAdapter{

	@Autowired
	PasswordEncode passwordEncode;
	
	@Bean
	public PasswordEncoder passwordEnconder() {
		return passwordEncode;
	}
	
//	@Bean(name = "pessoaS")
//	public PessoaService pessoaService() {
//		PessoaService pessoaService = new PessoaService();
//		return pessoaService;
//	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new PessoaService();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic();
		
		http.authorizeRequests().anyRequest().authenticated();
//		http.authorizeRequests()
//		.mvcMatchers("/user/ola").access("hasAnyAuthority('USER')");
	}

	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	
	
	
}
