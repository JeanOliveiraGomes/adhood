package com.adhood.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.adhood.util.GenericEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Campanha extends GenericEntity {
	
	private LocalDateTime dataInicio; 
	private LocalDateTime dataFim;
	private Float valorCampanha;
	private boolean status;
	
	@OneToMany
	private List<Motorista> participantes;

	@OneToMany
	private List<Cliente> cliente;

}
