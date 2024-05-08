package br.mackenzie.ProejtoN2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.mackenzie.ProejtoN2.model.Corrida;

@Repository
public interface CorridaRepository extends JpaRepository<Corrida, Long> {
}
