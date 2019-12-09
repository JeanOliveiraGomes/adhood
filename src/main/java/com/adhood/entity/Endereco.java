package com.adhood.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.adhood.enums.EstadosEnum;
import com.adhood.util.GenericEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Endereco extends GenericEntity {

	private String cep;
	private String bairro;
	private String complemento;
	private EstadosEnum uf;

}
