package br.mackenzie.ProejtoN2.model;

/**
 * 
 * 
 * @author Matheus Henrique de Oliveira Santos - TIA 42208149 - R.A 10409051 
 * @author Gabriel Mitelman Tkacz - TIA 42230446 - R.A 10358631
 * @author Cleide Lustosa de Oliveira da Silva - TIA 42218772 - R.A 10409459
 * @author Ricardo Carvalho Paixão Brandão - TIA 32097018 - R.A 10376918
 * 
 * 
*/

import jakarta.persistence.*;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Cidade {
    @Id @GeneratedValue
    private Long id;
    private String nome;
    private String estado;
    private Long populacao;

    @ManyToOne
    @JoinColumn(name = "pais_id")
    private Pais pais;

    @OneToMany(mappedBy = "cidade")
    private List<Corrida> corridas;

    public Cidade(){}

    public Cidade(Long id, String nome, String estado, Long populacao, Pais pais, List<Corrida> corridas) {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
        this.populacao = populacao;
        this.pais = pais;
        this.corridas = corridas;
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

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getPopulacao() {
        return this.populacao;
    }

    public void setPopulacao(Long populacao) {
        this.populacao = populacao;
    }

    public Pais getPais() {
        return this.pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public List<Corrida> getCorridas() {
        return this.corridas;
    }

    public void setCorridas(List<Corrida> corridas) {
        this.corridas = corridas;
    }
}
