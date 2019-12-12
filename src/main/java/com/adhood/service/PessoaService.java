package com.adhood.service;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adhood.entity.Perfil;
import com.adhood.entity.Pessoa;
import com.adhood.repository.PessoalRepository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;

@Service
public class PessoaService implements UserDetailsManager {
	
	@Autowired PessoalRepository pessoaRepository;

	public Pessoa salvarPessoa() {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("teste");
		pessoa.setEmail("email2");
		pessoa.setPassword("123");
		pessoa.setAccountNonLocked(true);
		pessoa.setAccountNonExpired(true);
		pessoa.setEnabled(true);
		return pessoaRepository.save(pessoa);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		salvarPessoa();
		pessoaRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Usuario ou senha invalidos"));
		return pessoaRepository.findByEmail(username).get();
	}

	@Override
	public void createUser(UserDetails user) {
		Pessoa pessoa = new Pessoa();
		pessoa.setEmail(user.getUsername());
		pessoa.setPassword(user.getPassword());
		pessoa.setAccountNonExpired(user.isAccountNonExpired());
		pessoa.setAccountNonLocked(user.isAccountNonLocked());
		pessoa.setCredentialsNonExpired(user.isCredentialsNonExpired());
		pessoa.setEnabled(user.isEnabled());
		ArrayList<Perfil> perfil = pessoa.getPerfil();
		perfil.add(new Perfil("USER"));
		//pessoa.setPerfil(Arrays.asList(user.getAuthorities().toArray()));
		pessoaRepository.save(pessoa);
	}

	@Override
	public void updateUser(UserDetails user) {
		Pessoa pessoa = pessoaRepository.findByEmail(user.getUsername()).orElse(null);
		pessoa.setEmail(user.getUsername());
		pessoa.setPassword(user.getPassword());
		pessoa.setAccountNonExpired(user.isAccountNonExpired());
		pessoa.setAccountNonLocked(user.isAccountNonLocked());
		pessoa.setCredentialsNonExpired(user.isCredentialsNonExpired());
		pessoa.setEnabled(user.isEnabled());
		//pessoa.setPerfil(Arrays.asList(user.getAuthorities().toArray()));
		pessoaRepository.save(pessoa);
	}

	@Override
	public void deleteUser(String username) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changePassword(String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean userExists(String username) {
		Pessoa pessoa = pessoaRepository.findByEmail(username).orElse(null);
		return Objects.nonNull(pessoa);
	}
}
