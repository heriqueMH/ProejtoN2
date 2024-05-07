package br.mackenzie.ProejtoN2.interfaces;

import br.mackenzie.ProejtoN2.model.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipeRepository extends JpaRepository<Equipe, Long> {
    // Aqui você pode adicionar métodos de consulta personalizados se necessário
}

