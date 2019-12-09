package com.adhood.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.adhood.enums.MotivoPeloQualDirigeEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "motorista")
public class Motorista extends Pessoa {

	private MotivoPeloQualDirigeEnum motivacao;
	
	@OneToOne
	private Cnh cnh;
	
	@OneToMany
	private List<CampDriver> campanha;
	
	@OneToMany
	private List<HistoricoLocalizacao> historicoLocalizacao;
	
}
