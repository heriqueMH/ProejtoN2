package br.mackenzie.ProejtoN2.repository;

import br.mackenzie.ProejtoN2.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {
}

