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

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Piloto {
    @Id @GeneratedValue
    private Long id;
    private String nome;
    private String numSuperlicenca;
    private LocalDate dataDeNascimento;

    @ManyToOne
    @JoinColumn(name = "equipe_id")
    private Equipe equipe;

    public Piloto() {}

    public Piloto(Long id, String nome, String numSuperlicenca, LocalDate dataDeNascimento, Equipe equipe) {
        this.id = id;
        this.nome = nome;
        this.numSuperlicenca = numSuperlicenca;
        this.dataDeNascimento = dataDeNascimento;
        this.equipe = equipe;
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

    public String getNumSuperlicenca() {
        return this.numSuperlicenca;
    }

    public void setNumSuperlicenca(String numSuperlicenca) {
        this.numSuperlicenca = numSuperlicenca;
    }

    public LocalDate getDataDeNascimento() {
        return this.dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public Equipe getEquipe() {
        return this.equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }
}


