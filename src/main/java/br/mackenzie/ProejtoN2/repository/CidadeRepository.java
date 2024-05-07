package br.mackenzie.ProejtoN2.repository;

import br.mackenzie.ProejtoN2.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {
}

