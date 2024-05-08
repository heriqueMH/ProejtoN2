package br.mackenzie.ProejtoN2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import br.mackenzie.ProejtoN2.model.Piloto;

public interface PilotoRepository extends JpaRepository<Piloto, Long> {
    List<Piloto> findByEquipeId(Long equipeId);

    List<Piloto> findByEquipeNome(String nomeEquipe);
}
