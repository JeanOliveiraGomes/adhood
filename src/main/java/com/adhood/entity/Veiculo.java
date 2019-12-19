package com.adhood.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.adhood.enums.CondicaoPinturaEnum;
import com.adhood.util.GenericEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Veiculo extends GenericEntity {

	private static final long serialVersionUID = -5233410385545715551L;
	
	private String placa;
	private Integer anoFabricacao;
	private String cor;
	private CondicaoPinturaEnum condicaoPintura;
	
	@ManyToOne
	private Pessoa proprietario;
	private String marca;
	
	public Veiculo () {
		super();
	}
	
}
