package com.adhood.entity;

import java.time.LocalDate;

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
public class Cnh extends GenericEntity {

	private static final long serialVersionUID = -1550883663965699373L;
	
	private LocalDate validade;
	
	@OneToOne
	private Motorista motorista;
}
