package br.mackenzie.ProejtoN2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

import br.mackenzie.ProejtoN2.model.Carro;

public interface CarroRepository extends JpaRepository<Carro, Long> {
    @Query("SELECT c FROM Carro c WHERE c.equipe.nome = :nomeEquipe")
    
    List<Carro> findByEquipeNome(@Param("nomeEquipe") String nomeEquipe);

    List<Carro> findByEquipeId(Long equipeId);
}

