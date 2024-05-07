package br.mackenzie.ProejtoN2.repository;

import br.mackenzie.ProejtoN2.model.Piloto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PilotoRepository extends JpaRepository<Piloto, Long> {
}
