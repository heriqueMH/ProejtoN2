package br.mackenzie.ProejtoN2.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Pais {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String continente;
    private Long populacao;

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

    @OneToMany(mappedBy = "pais")
    private List<Cidade> cidades;
}