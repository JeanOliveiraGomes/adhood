package com.adhood.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
	
	private static final long serialVersionUID = -7844178786806462516L;
	
	private String nome;
	private LocalDateTime dataInicio; 
	private LocalDateTime dataFim;
	private Float valorCampanha;
	private boolean status;
	
	@OneToMany
	private List<CampDriver> campDrive;

	@OneToMany
	private List<Cliente> cliente;
	
	public Campanha() {
		super();
		this.cliente = new ArrayList<Cliente>();
	}

}
