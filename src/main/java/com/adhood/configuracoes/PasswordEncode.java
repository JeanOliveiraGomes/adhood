package com.adhood.configuracoes;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncode implements PasswordEncoder{

	@Override
	public String encode(CharSequence rawPassword) {
		return rawPassword.toString();
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		System.out.println("password encoder" + rawPassword + "  "+ encodedPassword);
		return rawPassword.toString().equals(encodedPassword);
		
	}

}
