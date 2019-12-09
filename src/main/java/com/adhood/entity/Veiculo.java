package com.adhood.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.adhood.enums.CondicaoPinturaEnum;
import com.adhood.enums.MarcaVeiculoEnum;
import com.adhood.util.GenericEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Veiculo extends GenericEntity {

	private String placa;
	private Integer anoFabricacao;
	private String cor;
	private CondicaoPinturaEnum condicaoPintura;
	
	@OneToOne
	private Pessoa proprietario;
	private MarcaVeiculoEnum marca;
	
}
