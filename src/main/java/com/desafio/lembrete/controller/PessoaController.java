package com.desafio.lembrete.controller;


import com.desafio.lembrete.entity.Pessoa;
import com.desafio.lembrete.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {


    @Autowired
   private PessoaService pessoaService;



    @GetMapping()
    public ResponseEntity<List<Pessoa>> findAll() {
        try {
            return ResponseEntity.ok(pessoaService.findAll());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }



    @PostMapping
    public ResponseEntity<String> cadastrar(@RequestBody  Pessoa pessoa){

        try{
                pessoaService.cadastrar(pessoa);
            return ResponseEntity.ok("realizado com sucesso");
        }

        catch (Exception e){

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());

        }


    }



    @PutMapping("/{id}")
    public ResponseEntity<String> editar(@RequestBody Pessoa pessoa, @PathVariable Long id){

        try {
            pessoaService.editar(pessoa,id);
            return ResponseEntity.ok("Pessoa editada com sucesso");
        }

        catch (Exception e){

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }

    }




    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id){

        try {
            pessoaService.deletar(id);
            return ResponseEntity.status((HttpStatus.NOT_FOUND)).body("Pessoa Excluida");
        }
        catch (Exception e){

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

        }


    }





}
