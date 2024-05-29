package br.mackenzie.ProejtoN2.model;

import jakarta.persistence.*;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Pais {
    @Id @GeneratedValue
    private Long id;
    private String nome;
    private String continente;
    private Long populacao;
    
    @OneToMany(mappedBy = "pais")
    @JsonBackReference
    private List<Cidade> cidades;

    public Pais() {}

    public Pais(Long id, String nome, String continente, Long populacao, List<Cidade> cidades) {
        this.id = id;
        this.nome = nome;
        this.continente = continente;
        this.populacao = populacao;
        this.cidades = cidades;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContinente() {
        return this.continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public Long getPopulacao() {
        return this.populacao;
    }

    public void setPopulacao(Long populacao) {
        this.populacao = populacao;
    }

    public List<Cidade> getCidades() {
        return this.cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }
}
