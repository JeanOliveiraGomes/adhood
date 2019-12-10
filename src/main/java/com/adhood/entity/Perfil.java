package com.adhood.entity;

import javax.persistence.Entity;

import org.springframework.security.core.GrantedAuthority;

import com.adhood.util.GenericEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
public class Perfil extends GenericEntity implements GrantedAuthority {
	
	private String perfil;

	@Override
	public String getAuthority() {
		return perfil;
	}
}
