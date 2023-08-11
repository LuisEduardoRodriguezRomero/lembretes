package com.desafio.lembrete.repository;

import com.desafio.lembrete.entity.Lembrete;
import com.desafio.lembrete.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;




public interface LembreteRepository extends JpaRepository<Lembrete, Long> {




}
