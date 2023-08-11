package com.desafio.lembrete.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "lembrete", schema = "public")
public class Lembrete {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String lembrete;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_pessoa", nullable = false)
    private Pessoa id_pessoa;


    public Lembrete(Long id, String lembrete, Pessoa id_pessoa) {
        this.id = id;
        this.lembrete = lembrete;
        this.id_pessoa = id_pessoa;
    }

    public Lembrete() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLembrete() {
        return lembrete;
    }

    public void setLembrete(String lembrete) {
        this.lembrete = lembrete;
    }

    public Pessoa getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(Pessoa id_pessoa) {
        this.id_pessoa = id_pessoa;
    }
}
