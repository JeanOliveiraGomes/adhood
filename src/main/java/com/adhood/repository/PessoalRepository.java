package com.adhood.repository;

import org.springframework.data.repository.CrudRepository;

import com.adhood.entity.Pessoa;

public interface PessoalRepository extends CrudRepository<Pessoa, Long>{

}
