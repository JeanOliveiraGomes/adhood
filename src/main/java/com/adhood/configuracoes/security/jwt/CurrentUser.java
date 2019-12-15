package com.adhood.configuracoes.security.jwt;

import org.springframework.stereotype.Service;

import com.adhood.configuracoes.security.CustomUserDetails;
import com.adhood.entity.Pessoa;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@Service
@AllArgsConstructor
public class CurrentUser {
	private String token;
	private CustomUserDetails userDetails;
	
	public CurrentUser() {
		super();
	}
}
