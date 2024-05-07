package br.mackenzie.ProejtoN2.model;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Equipes")
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
}