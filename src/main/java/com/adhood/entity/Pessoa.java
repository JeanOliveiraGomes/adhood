package com.adhood.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.adhood.util.GenericEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Pessoa extends GenericEntity {

	private String nome;
	private String email;
	private String cpf;
	private LocalDateTime dataNascimento;
	private String telefone;
	
	@OneToMany
	private List<Endereco> endereco;
	
	@OneToMany
	private List<Veiculo> veiculo;
	
	@OneToMany
	private List<Perfil> perfil;
	
	@OneToOne
	private Password password;
	
	public Pessoa() {
		super();
	}
}
