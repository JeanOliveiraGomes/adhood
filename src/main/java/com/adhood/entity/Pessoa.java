package com.adhood.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.adhood.util.GenericEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Pessoa extends GenericEntity{
	
	private static final long serialVersionUID = -939743917275900732L;
	
	private String nome;
	@Column(unique = true, nullable = false)
	private String email;
	@Column(unique = true)
	private String cpf;
	private LocalDate dataNascimento;
	private String telefone;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Endereco> endereco;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Veiculo> veiculo;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Motorista motorista;
	
	private ArrayList<Perfil> perfil;
	
	@JsonIgnore
	private String password;
	
	private boolean isAccountNonExpired;
	
	private boolean isAccountNonLocked;
	
	private boolean isCredentialsNonExpired;
	
	private boolean isEnabled;
	
	
	
	public Pessoa() {
		super();
		this.perfil = new ArrayList<>();
		this.veiculo = new ArrayList<>();
		this.endereco = new ArrayList<>();
	}
}
