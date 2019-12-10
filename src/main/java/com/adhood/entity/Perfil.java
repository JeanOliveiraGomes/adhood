package com.adhood.entity;

import javax.persistence.Entity;

import com.adhood.util.GenericEntity;

import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Perfil extends GenericEntity {
	
	private String perfil;
}
