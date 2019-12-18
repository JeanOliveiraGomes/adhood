package com.adhood.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

	@OneToOne(cascade = CascadeType.ALL)
	private Pessoa pessoa;
	
	private MotivoPeloQualDirigeEnum motivacao;
	
	@OneToOne
	private Cnh cnh;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<CampDriver> campanha;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<HistoricoLocalizacao> historicoLocalizacao;
	
	public Motorista () {
		super();
		this.campanha = new ArrayList<CampDriver>();
		this.historicoLocalizacao = new ArrayList<>();
	}
	
}
