package com.desafio.lembrete.servicetest;


import com.desafio.lembrete.entity.Lembrete;
import com.desafio.lembrete.entity.Pessoa;
import com.desafio.lembrete.repository.LembreteRepository;
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
public class LembreteTest {

    @MockBean
    LembreteService lembreteService;

    @MockBean
    LembreteRepository lembreteRepository;

    @MockBean
    PessoaRepository pessoaRepository;


@BeforeEach
    void criarLembrete(){
    Pessoa pessoa = new Pessoa(1L, "Eduardo");
    Lembrete lembrete = new Lembrete(1L,"Lembrete 1",pessoa);

    Mockito.when(pessoaRepository.findById(1L)).thenReturn(Optional.of(pessoa));
    Mockito.when(lembreteRepository.findById(1L)).thenReturn(Optional.of(lembrete));

    Mockito.when(lembreteService.cadastrar(lembrete)).thenReturn(lembrete);


}

@Test
    public void cadastrarLembreteTest(){

    var lembrete = lembreteRepository.findById(1L).get();

    Assertions.assertEquals(lembrete,lembreteService.cadastrar(lembrete));
}


@Test
    public void findLembreteByIdTest(){

    Optional<Lembrete> lembreteTest = lembreteRepository.findById(1L);

    Long id = lembreteTest.get().getId();

    Assertions.assertEquals(lembreteTest,lembreteRepository.findById(id));
}







}
