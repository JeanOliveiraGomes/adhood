package com.adhood.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.adhood.util.GenericEntity;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class CampDriver extends GenericEntity{
	
	private static final long serialVersionUID = -7383395667628487787L;
	
	private LocalDateTime dataInicio;
	private LocalDateTime dataFim;
	
	@OneToOne
	private Campanha campanha;
	
	@OneToOne
	private Motorista motorista;
	
	public CampDriver () {
		super();
	}
}
