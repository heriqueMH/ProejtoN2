package br.mackenzie.ProejtoN2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import br.mackenzie.ProejtoN2.model.Carro;
import br.mackenzie.ProejtoN2.model.Equipe;

public interface EquipeRepository extends JpaRepository<Equipe, Long> {
    @Query("SELECT c FROM Carro c WHERE c.equipe.id = :equipeId")
    
    List<Carro> findByEquipeId(@Param("equipeId") Long equipeId);
}

