package com.desafio.lembrete.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "pessoa", schema = "public")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;

    private String name;


    public Pessoa(Long id, String name) {
        this.id = id;
        this.name = name;
    }


    public Pessoa( ) {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
