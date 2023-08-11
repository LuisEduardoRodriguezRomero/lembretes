package com.desafio.lembrete.repository;

import com.desafio.lembrete.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository  extends JpaRepository<Pessoa, Long> {

}
