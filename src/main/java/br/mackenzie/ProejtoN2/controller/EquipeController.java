package br.mackenzie.ProejtoN2.controller;

import br.mackenzie.ProejtoN2.model.Equipe;
import br.mackenzie.ProejtoN2.repository.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipes")
public class EquipeController {

    @Autowired
    private EquipeRepository equipeRepository;

    @GetMapping
    public List<Equipe> listarTodasEquipes() {
        return equipeRepository.findAll();
    }

    @PostMapping
    public Equipe criarEquipe(@RequestBody Equipe equipe) {
        return equipeRepository.save(equipe);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipe> obterEquipePorId(@PathVariable Long id) {
        return equipeRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipe> atualizarEquipe(@PathVariable Long id, @RequestBody Equipe equipeDetalhes) {
        return equipeRepository.findById(id)
                .map(equipe -> {
                    equipe.setNomeEquipe(equipeDetalhes.getNomeEquipe());
                    equipe.setQtdeFunc(equipeDetalhes.getQtdeFunc());
                    equipe.setPais(equipeDetalhes.getPais());
                    return ResponseEntity.ok(equipeRepository.save(equipe));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEquipe(@PathVariable Long id) {
        return equipeRepository.findById(id)
                .map(equipe -> {
                    equipeRepository.delete(equipe);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
