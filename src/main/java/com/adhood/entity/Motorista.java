package com.adhood.entity;

import java.util.ArrayList;
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

	private static final long serialVersionUID = -3730506979396793917L;

	private MotivoPeloQualDirigeEnum motivacao;
	
	@OneToOne
	private Cnh cnh;
	
	@OneToMany
	private List<CampDriver> campanha;
	
	@OneToMany
	private List<HistoricoLocalizacao> historicoLocalizacao;
	
	public Motorista () {
		super();
		this.campanha = new ArrayList<CampDriver>();
		this.historicoLocalizacao = new ArrayList<>();
	}
	
}
