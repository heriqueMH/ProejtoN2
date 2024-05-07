package br.mackenzie.ProejtoN2.model;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Corridas")
public class Corrida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Date data;
    private String circuito;
    private String condicoesClimaticas;

    @ManyToOne
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;
}