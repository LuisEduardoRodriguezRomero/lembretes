package com.desafio.lembrete.controller;


import com.desafio.lembrete.entity.Pessoa;
import com.desafio.lembrete.entity.Lembrete;
import com.desafio.lembrete.service.LembreteService;
import com.desafio.lembrete.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/lembretes")
public class LembreteController {

    @Autowired
    private LembreteService lembreteService;



    @GetMapping()
    public ResponseEntity<List<Lembrete>> findAll() {
        try {
            return ResponseEntity.ok(lembreteService.findAll());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }


    @PostMapping
    public ResponseEntity<String> cadastrar(@RequestBody Lembrete lembrete){
        try {
            lembreteService.cadastrar(lembrete);
            return ResponseEntity.ok("Lembrete cadastrado");
        }

        catch (Exception e){

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }


    }


    @PutMapping("/{id}")
    public ResponseEntity<String> editar(@RequestBody Lembrete lembrete, @PathVariable Long id){

        try {
            lembreteService.editar(lembrete,id);
            return ResponseEntity.ok("Lembrete editada com sucesso");
        }

        catch (Exception e){

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }

    }



    @DeleteMapping("/{id}")
    public ResponseEntity<String> editar( @PathVariable Long id){

        try {
            lembreteService.deletar(id);
            return ResponseEntity.ok("Lembrete deletado com sucesso");
        }

        catch (Exception e){

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }

    }



}
