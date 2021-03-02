package com.adhood.entity;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.adhood.util.GenericEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Pessoa extends GenericEntity{
	
	private static final long serialVersionUID = -939743917275900732L;
	
	@Id
    @GeneratedValue
	public Long id;
	@Column(nullable = false)
	private String nome;
	@Column(unique = true, nullable = true)
	private String email;
	@Column(unique = true, nullable = false)
	private String cpf;
	@Column(unique = false, nullable = false)
	private LocalDate dataNascimento;
	private String sexo;
	private String naturalidade;
	private String nacionalidade;
		
	private ArrayList<Perfil> perfil;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	
	@JsonIgnore
	private boolean isAccountNonExpired;
	
	@JsonIgnore
	private boolean isAccountNonLocked;
	
	@JsonIgnore
	private boolean isCredentialsNonExpired;
	
	private boolean isEnabled;
	
	public Pessoa() {
		super();
		this.perfil = new ArrayList<>();
	}
}
