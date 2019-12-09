package com.adhood.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.adhood.enums.PortClienteEnum;
import com.adhood.util.GenericEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Cliente extends GenericEntity {
	
	private String nome;
	private String segmento;
	
	@OneToMany
	private List<Endereco> endereco;
	@ManyToOne
	private Pessoa consultor;
	private boolean status;
	
	private PortClienteEnum porte;
	
	@OneToMany
	private List<Campanha> campanhas;

}
