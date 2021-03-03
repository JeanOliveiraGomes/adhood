package com.adhood.mapping;

import org.springframework.stereotype.Component;

import com.adhood.dtos.PessoaDTO;
import com.adhood.entity.Pessoa;

@Component
public class PessoaMapping implements AbstractMapper<Pessoa, PessoaDTO> {
	
	public Pessoa dtoParaEntidade(PessoaDTO dto) {
		return Pessoa.builder().id(dto.getId()).sexo(dto.getSexo()).cpf(dto.getCpf()).dataNascimento(dto.getDataNascimento()).email(dto.getEmail())
				.nome(dto.getNome()).password(dto.getPassword()).perfil(dto.getPerfil()).nacionalidade(dto.getNacionalidade())
				.naturalidade(dto.getNaturalidade()).build();
	}
	
	public PessoaDTO entidadeParaDTO(Pessoa entity) {
		return PessoaDTO.builder().id(entity.getId()).sexo(entity.getSexo()).cpf(entity.getCpf()).dataNascimento(entity.getDataNascimento())
				.email(entity.getEmail()).nome(entity.getNome()).password(entity.getPassword())
				.perfil(entity.getPerfil()).nacionalidade(entity.getNacionalidade()).naturalidade(entity.getNaturalidade()).build();
	}

}
