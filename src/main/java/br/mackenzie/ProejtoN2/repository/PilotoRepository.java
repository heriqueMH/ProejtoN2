package br.mackenzie.ProejtoN2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import br.mackenzie.ProejtoN2.model.Piloto;

public interface PilotoRepository extends JpaRepository<Piloto, Long> {
    @Query("SELECT p FROM Piloto p WHERE p.equipe.id = :equipeId")
    List<Piloto> findByEquipeId(@Param("equipeId") Long equipeId);

    @Query("SELECT p FROM Piloto p WHERE p.equipe.nomeEquipe = :nomeEquipe")
    List<Piloto> findByEquipeNome(@Param("nomeEquipe") String nomeEquipe);
}
