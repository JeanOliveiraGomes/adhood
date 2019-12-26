package com.adhood.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.adhood.util.GenericEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class HistoricoLocalizacao extends GenericEntity{

	private static final long serialVersionUID = 2648910650843776341L;
	
	private Timestamp timestamp;
	private String latitude;
	private String logitude;
	
}
