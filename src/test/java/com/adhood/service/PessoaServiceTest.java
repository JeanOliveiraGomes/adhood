package com.adhood.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.adhood.mapping.PessoaMapping;

import com.adhood.dtos.PessoaDTO;
import com.adhood.entity.Pessoa;
import com.adhood.repository.PessoalRepository;

@RunWith(MockitoJUnitRunner.class)
public class PessoaServiceTest {

	private PessoaService pessoaService;
	@Mock
	private PessoalRepository pessoalRepository;
	@Mock
	private PasswordEncoder passwordEncoder;
	@Mock
	private PessoaMapping pessoaMapping;
	
	
    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        this.pessoaService = new PessoaService(pessoalRepository, passwordEncoder, pessoaMapping);
    }
	
	@Test
	public void savarPessoaRetornoNaoNulo() {
		Pessoa pessoa = Pessoa.builder().cpf("32566103070").nome("teste")
				.dataNascimento(LocalDate.of(2000, 2, 2)).email("teste@teste.com").build();
		
		PessoaDTO dto = PessoaDTO.builder().cpf("32566103070").nome("teste")
				.dataNascimento(LocalDate.of(2000, 2, 2)).email("teste@teste.com").build();
		Mockito.when(pessoalRepository.save(Mockito.any(Pessoa.class))).thenReturn(pessoa);
		PessoaDTO dto2 = pessoaService.save(dto);
		assertThat(dto2).isNotNull();
	}
	
	@Test
	public void encontrarPorNomeNaoVazio() {
		Pessoa pessoa = Pessoa.builder().cpf("32566103070").nome("teste")
				.dataNascimento(LocalDate.of(2000, 2, 2)).email("teste@teste.com").build();
		
		List<Pessoa> lista = new ArrayList<>();
		lista.add(pessoa);
		
		Mockito.when(pessoalRepository
				.findByNomeContainingIgnoreCase("nome", PageRequest.of(0, 10, Sort.Direction.DESC, "nome")))
				.thenReturn(lista);
		List<PessoaDTO> list = pessoaService.findByNome("nome");
		assertThat(list).isNotEmpty();
	}
	
	@Test
	public void encontrarTodosNaoVazio() {
		Pessoa pessoa = Pessoa.builder().cpf("32566103070").nome("teste")
				.dataNascimento(LocalDate.of(2000, 2, 2)).email("teste@teste.com").build();
		
		List<Pessoa> lista = new ArrayList<>();
		lista.add(pessoa);
		
		Mockito.when(pessoalRepository.findAll()).thenReturn(lista);
		List<PessoaDTO> list = pessoaService.findAll();
		assertThat(list).isNotEmpty();
	}

}
