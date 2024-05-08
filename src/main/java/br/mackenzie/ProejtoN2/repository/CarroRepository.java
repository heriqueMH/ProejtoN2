package br.mackenzie.ProejtoN2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.mackenzie.ProejtoN2.model.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {
}

