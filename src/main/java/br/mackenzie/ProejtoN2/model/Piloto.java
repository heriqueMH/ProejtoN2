package br.mackenzie.ProejtoN2.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Piloto {
    @Id @GeneratedValue
    private Long id;
    private String nome;
    private String numSuperlicenca;
    private Date dataDeNascimento;

    public Piloto() {}

    public Piloto(Long id, String nome, String numSuperlicenca, Date dataDeNascimento, Equipe equipe) {
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

    public Date getDataDeNascimento() {
        return this.dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
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


