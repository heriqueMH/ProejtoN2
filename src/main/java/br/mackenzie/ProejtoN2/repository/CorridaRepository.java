package br.mackenzie.ProejtoN2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

import br.mackenzie.ProejtoN2.model.Corrida;

public interface CorridaRepository extends JpaRepository<Corrida, Long> {
    @Query("SELECT c FROM Corrida c WHERE c.cidade.nome = :nomeCidade")

    List<Corrida> findByCidadeNome(@Param("nomeCidade") String nomeCidade);
}
