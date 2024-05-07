package br.mackenzie.ProejtoN2.repository;

import br.mackenzie.ProejtoN2.model.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {
}

