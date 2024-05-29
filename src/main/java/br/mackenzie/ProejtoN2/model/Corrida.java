package br.mackenzie.ProejtoN2.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Corrida {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private LocalDate data;
    private String circuito;
    private String condicoesClimaticas;

    @ManyToOne
    @JoinColumn(name = "cidade_id")
    @JsonManagedReference
    private Cidade cidade;

    @ManyToMany(mappedBy = "corridas")
    private List<Equipe> equipes;

    public Corrida() {}

    public Corrida(Long id, String nome, LocalDate data, String circuito, String condicoesClimaticas, Cidade cidade) {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.circuito = circuito;
        this.condicoesClimaticas = condicoesClimaticas;
        this.cidade = cidade;
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

    public LocalDate getData() {
        return this.data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getCircuito() {
        return this.circuito;
    }

    public void setCircuito(String circuito) {
        this.circuito = circuito;
    }

    public String getCondicoesClimaticas() {
        return this.condicoesClimaticas;
    }

    public void setCondicoesClimaticas(String condicoesClimaticas) {
        this.condicoesClimaticas = condicoesClimaticas;
    }

    public Cidade getCidade() {
        return this.cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public List<Equipe> getEquipes() {
        return this.equipes;
    }

    public void setEquipes(List<Equipe> equipes) {
        this.equipes = equipes;
    }
}
