package com.adhood.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.adhood.entity.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long>{
	
	List<Cliente> findByNomeContainingIgnoreCase(String nome, Pageable pegeable);
}
