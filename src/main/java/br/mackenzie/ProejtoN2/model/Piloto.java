package br.mackenzie.ProejtoN2.model;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Pilotos")
public class Piloto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String numSuperlicenca;
    private Date dataDeNascimento;

    @ManyToOne
    @JoinColumn(name = "equipe_id")
    private Equipe equipe;
}

