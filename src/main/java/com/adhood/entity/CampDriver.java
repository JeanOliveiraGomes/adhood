package com.adhood.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

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
	
	@ManyToOne
	private Campanha campanha;
	
	@ManyToOne
	private Pessoa pessoa;
	
	public CampDriver () {
		super();
	}
}
