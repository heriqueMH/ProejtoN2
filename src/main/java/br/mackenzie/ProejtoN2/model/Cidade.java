package br.mackenzie.ProejtoN2.model;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Data
@Entity
@Table(name = "Cidades")
public class Cidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String estado;
    private Long populacao;

    @ManyToOne
    @JoinColumn(name = "pais_id")
    private Pais pais;
}