package com.adhood.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
	
	@Column(nullable = false)
	private String nome;
	private String segmento;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Endereco> endereco;
	@ManyToOne
	private Pessoa consultor;
	private boolean status;
	
	private PortClienteEnum porte;
	
	public Cliente() {
		super();
	}

}
