package com.adhood.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.*;
import com.adhood.util.GenericEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

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
	
	@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	private List<HistoricoLocalizacao> historicoLocalizacao;
	
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
		this.veiculo = new ArrayList<>();
		this.endereco = new ArrayList<>();
	}
}
