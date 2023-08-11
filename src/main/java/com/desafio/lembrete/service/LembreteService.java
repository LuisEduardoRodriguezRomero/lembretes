package com.desafio.lembrete.service;


import com.desafio.lembrete.entity.Lembrete;
import com.desafio.lembrete.repository.LembreteRepository;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class LembreteService {


    @Autowired
   private  LembreteRepository lembreteRepository;


    public List<Lembrete> findAll(){

        return lembreteRepository.findAll();
    }



    @Transactional(rollbackFor = Exception.class)
    public Lembrete cadastrar(Lembrete lembrete){


        Assert.notNull(lembrete.getId_pessoa(),"Precisa asociar uma pessoa ao lembrete");

        return this.lembreteRepository.save(lembrete);

    }


    @Transactional(rollbackFor = Exception.class)
    public Lembrete editar(Lembrete lembrete, Long id){

        Optional<Lembrete> lembreteBD = lembreteRepository.findById(id);
        Assert.isTrue(!lembreteBD.isEmpty(),";Lembrete nao cadastrado");

        return this.lembreteRepository.save(lembrete);

    }



    @Transactional(rollbackFor = Exception.class)
    public void deletar( Long id){

        Optional<Lembrete> lembreteBD = lembreteRepository.findById(id);
        Assert.isTrue(!lembreteBD.isEmpty(),";Lembrete nao cadastrado");

         lembreteRepository.deleteById(id);

    }


}
