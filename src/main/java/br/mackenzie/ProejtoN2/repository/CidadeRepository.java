package br.mackenzie.ProejtoN2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

import br.mackenzie.ProejtoN2.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
    @Query("SELECT c FROM Cidade c WHERE c.populacao >= :populacao")
    List<Cidade> findByPopulacaoGreaterThanEqual(@Param("populacao") Long populacao);

    @Query("SELECT c FROM Cidade c WHERE c.pais.id = :paisId")
    List<Cidade> findByPaisId(@Param("paisId") Long paisId);
}
