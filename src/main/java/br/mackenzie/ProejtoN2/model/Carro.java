package br.mackenzie.ProejtoN2.model;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Carros")
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String modelo;
    private String marca;
    private Integer ano;
    private String categoria;

    @ManyToOne
    @JoinColumn(name = "equipe_id")
    private Equipe equipe;
}