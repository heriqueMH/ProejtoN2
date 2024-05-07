package br.mackenzie.ProejtoN2.repository;

import br.mackenzie.ProejtoN2.model.Corrida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorridaRepository extends JpaRepository<Corrida, Long> {
}
