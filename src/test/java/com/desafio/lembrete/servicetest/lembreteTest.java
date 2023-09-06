package com.desafio.lembrete.servicetest;


import com.desafio.lembrete.service.LembreteService;
import com.desafio.lembrete.service.PessoaService;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class lembreteTest {

    @MockBean
    LembreteService lembreteService;

    @MockBean
    PessoaService pessoaService;









}
