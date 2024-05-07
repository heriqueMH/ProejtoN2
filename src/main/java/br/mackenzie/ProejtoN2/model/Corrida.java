package br.mackenzie.ProejtoN2.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Corrida {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Date data;
    private String circuito;
    private String condicoesClimaticas;

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

    public Date getData() {
        return this.data;
    }

    public void setData(Date data) {
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

    @ManyToOne
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;
}
