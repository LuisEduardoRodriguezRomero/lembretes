package com.desafio.lembrete.servicetest;


import com.desafio.lembrete.entity.Lembrete;
import com.desafio.lembrete.entity.Pessoa;
import com.desafio.lembrete.repository.PessoaRepository;
import com.desafio.lembrete.service.LembreteService;
import com.desafio.lembrete.service.PessoaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

@SpringBootTest
public class lembreteTest {

    @MockBean
    LembreteService lembreteService;

    @MockBean
    PessoaRepository pessoaRepository;


@BeforeEach
    void criarPessoa(){
    Optional<Pessoa> pessoa = Optional.of(new Pessoa(1L, "Eduardo"));
    Lembrete lembrete = new Lembrete(1L,"Lembrete 1",pessoaRepository.findById(1L).get());

    Mockito.when(pessoaRepository.findById(1L)).thenReturn(pessoa);

    Mockito.when(lembreteService.cadastrar(lembrete)).thenReturn(lembrete);


}

@Test
    public void cadastrarLembreteTest(){

    Assertions.assertEquals(lembreteService.cadastrar(new Lembrete(1L,"Lembrete 1",pessoaRepository.findById(1L).get())));


}




}
