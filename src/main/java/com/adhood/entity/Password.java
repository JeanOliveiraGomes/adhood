package com.adhood.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.adhood.util.GenericEntity;

import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Password extends GenericEntity {
	
	@OneToOne
	private Pessoa pessoa;
	private String password;
}
