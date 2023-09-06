package com.desafio.lembrete.servicetest;


import com.desafio.lembrete.entity.Pessoa;
import com.desafio.lembrete.repository.PessoaRepository;
import com.desafio.lembrete.service.PessoaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

@SpringBootTest
public class PessoaTest {


    @MockBean
    PessoaService pessoaService;

    @MockBean
    PessoaRepository pessoaRepository;

    @BeforeEach
    void CriarPessoa (){


        Pessoa pessoa = new Pessoa(1L,"LUIS");

        Mockito.when(pessoaRepository.save(pessoa)).thenReturn(pessoa);

        Mockito.when(pessoaRepository.findById(1L)).thenReturn(Optional.of(pessoa));

    }


    @Test
    public  void cadastrarPessoatest(){

        Assertions.assertEquals(pessoaRepository.save(new Pessoa(1L,"LUIS")),pessoaService.cadastrar(new Pessoa(1L,"LUIS")));

    }

    @Test
    public  void getByIdTest(){

        var pessoatest = pessoaRepository.findById(1L);
        Long id = pessoatest.get().getId();

        Assertions.assertEquals(pessoatest,pessoaRepository.findById(id));
        

    }





}
