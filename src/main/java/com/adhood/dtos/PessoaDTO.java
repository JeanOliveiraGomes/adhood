package com.adhood.dtos;

import java.time.LocalDate;
import java.util.ArrayList;


import com.adhood.entity.Perfil;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class PessoaDTO {
	
    private Long id;
	private String nome;
	private String email;
	private String cpf;
	private LocalDate dataNascimento;
	private String sexo;
	private String naturalidade;
	private String nacionalidade;
		
	private ArrayList<Perfil> perfil;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
}
