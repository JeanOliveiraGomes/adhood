package com.adhood.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.adhood.enums.MotivoPeloQualDirigeEnum;
import com.adhood.util.GenericEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "motorista")
public class Motorista extends GenericEntity {

	private static final long serialVersionUID = -3730506979396793917L;
	
	private MotivoPeloQualDirigeEnum motivacao;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Cnh cnh;
	
	public Motorista () {
		super();
	}
	
}
