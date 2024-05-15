package br.mackenzie.ProejtoN2.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Equipe {
    @Id @GeneratedValue
    private Long id;
    private String nomeEquipe;
    private Integer qtdeFunc;

    @ManyToOne
    @JoinColumn(name = "pais_id")
    private Pais pais;

    @OneToMany(mappedBy = "equipe")
    private List<Piloto> pilotos;

    @OneToMany(mappedBy = "equipe")
    private List<Carro> carros;

    @ManyToMany
    @JoinTable(
        name = "equipe_corrida",
        joinColumns = @JoinColumn(name = "equipe_id"),
        inverseJoinColumns = @JoinColumn(name = "corrida_id"))
    private List<Corrida> corridas;

    public Equipe() {}

    public Equipe(Long id, String nomeEquipe, Integer qtdeFunc, Pais pais, List<Piloto> pilotos, List<Carro> carros) {
        this.id = id;
        this.nomeEquipe = nomeEquipe;
        this.qtdeFunc = qtdeFunc;
        this.pais = pais;
        this.pilotos = pilotos;
        this.carros = carros;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeEquipe() {
        return this.nomeEquipe;
    }

    public void setNomeEquipe(String nomeEquipe) {
        this.nomeEquipe = nomeEquipe;
    }

    public Integer getQtdeFunc() {
        return this.qtdeFunc;
    }

    public void setQtdeFunc(Integer qtdeFunc) {
        this.qtdeFunc = qtdeFunc;
    }

    public Pais getPais() {
        return this.pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public List<Piloto> getPilotos() {
        return this.pilotos;
    }

    public void setPilotos(List<Piloto> pilotos) {
        this.pilotos = pilotos;
    }

    public List<Carro> getCarros() {
        return this.carros;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }
}

