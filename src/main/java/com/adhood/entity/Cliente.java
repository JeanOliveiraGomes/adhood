package com.adhood.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
	
	private static final long serialVersionUID = -928008812012299985L;
	
	private String nome;
	private String segmento;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Endereco> endereco;
	@ManyToOne(cascade = CascadeType.ALL)
	private Pessoa consultor;
	private boolean status;
	
	private PortClienteEnum porte;
	
	@OneToMany
	private List<Campanha> campanhas;
	
	public Cliente() {
		super();
		this.campanhas = new ArrayList<Campanha>();
	}

}
