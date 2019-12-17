package com.adhood.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.adhood.enums.EstadosEnum;
import com.adhood.util.GenericEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Endereco extends GenericEntity {

	private static final long serialVersionUID = -8945666229445887747L;
	
	private String cep;
	private String bairro;
	private String complemento;
	private EstadosEnum uf;
	@ManyToOne(fetch = FetchType.LAZY)
	private Cliente cliente;
	
	
	public Endereco() {
		super();
	}

}
