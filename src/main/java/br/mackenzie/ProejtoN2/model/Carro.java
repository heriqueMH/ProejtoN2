package br.mackenzie.ProejtoN2.model;

import jakarta.persistence.*;

@Entity
public class Carro {
    @Id @GeneratedValue
    private Long id;
    private String modelo;
    private String marca;
    private Integer ano;
    private String categoria;

    
    public Carro(){}

    public Carro(Long id, String modelo, String marca, Integer ano, String categoria, Equipe equipe) {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.categoria = categoria;
        this.equipe = equipe;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getAno() {
        return this.ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Equipe getEquipe() {
        return this.equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    @ManyToOne
    @JoinColumn(name = "equipe_id")
    private Equipe equipe;
}
