package com.desafio.lembrete.service;


import com.desafio.lembrete.entity.Pessoa;
import com.desafio.lembrete.repository.PessoaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {


    @Autowired
   private PessoaRepository pessoaRepository;



    public List<Pessoa> findAll(){

        return pessoaRepository.findAll();
    }



    @Transactional(rollbackFor = Exception.class)
    public Pessoa cadastrar(Pessoa pessoa){


        return this.pessoaRepository.save(pessoa);



    }



    @Transactional(rollbackFor = Exception.class)
    public Pessoa editar(Pessoa pessoa, Long id){


        Optional<Pessoa> pessoaDB = pessoaRepository.findById(id);

        Assert.isTrue(!pessoaDB.isEmpty(),"Pessoa nao cadastrada");

        return pessoaRepository.save(pessoa);

    }




    @Transactional(rollbackFor = Exception.class)
    public String deletar(Long id){

        Optional<Pessoa> pessoaDB = pessoaRepository.findById(id);

        Assert.isTrue(!pessoaDB.isEmpty(),"Pessoa nao cadastrada");

        pessoaRepository.deleteById(id);
        return "Pessoa excluida";

    }



}


