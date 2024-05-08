package br.mackenzie.ProejtoN2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import br.mackenzie.ProejtoN2.model.Carro;
import br.mackenzie.ProejtoN2.model.Equipe;

public interface EquipeRepository extends JpaRepository<Equipe, Long> {
    List<Carro> findByEquipeId(Long equipeId);
}

