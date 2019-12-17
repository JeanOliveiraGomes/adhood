package com.adhood.repository;

import org.springframework.data.repository.CrudRepository;

import com.adhood.entity.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long>{
}
