package br.mackenzie.ProejtoN2.repository;

/**
 * 
 * 
 * @author Matheus Henrique de Oliveira Santos - TIA 42208149 - R.A 10409051 
 * @author Gabriel Mitelman Tkacz - TIA 42230446 - R.A 10358631
 * @author Cleide Lustosa de Oliveira da Silva - TIA 42218772 - R.A 10409459
 * @author Ricardo Carvalho Paixão Brandão - TIA 32097018 - R.A 10376918
 * 
 * 
*/

import org.springframework.data.jpa.repository.JpaRepository;

import br.mackenzie.ProejtoN2.model.Pais;

public interface PaisRepository extends JpaRepository<Pais, Long> {
}

