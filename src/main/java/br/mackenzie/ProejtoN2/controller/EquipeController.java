package br.mackenzie.ProejtoN2.controller;

import br.mackenzie.ProejtoN2.interfaces.EquipeRepository;
import br.mackenzie.ProejtoN2.model.Equipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/equipes")
public class EquipeController {
    @Autowired
    private EquipeRepository equipeRepository;

    @GetMapping
    public List<Equipe> getAllEquipes() {
        return equipeRepository.findAll();
    }

    @PostMapping
    public Equipe createEquipe(@RequestBody Equipe equipe) {
        return equipeRepository.save(equipe);
    }

    @GetMapping("/{id}")
    public Equipe getEquipeById(@PathVariable Long id) {
        return equipeRepository.findById(id).orElseThrow(() -> new RuntimeException("Equipe não encontrada"));
    }

    @PutMapping("/{id}")
    public Equipe updateEquipe(@PathVariable Long id, @RequestBody Equipe equipeDetails) {
        Equipe equipe = equipeRepository.findById(id).orElseThrow(() -> new RuntimeException("Equipe não encontrada"));
        equipe.setNomeEquipe(equipeDetails.getNomeEquipe());
        equipe.setQtdeFunc(equipeDetails.getQtdeFunc());
        equipe.setPais(equipeDetails.getPais());
        return equipeRepository.save(equipe);
    }

    @DeleteMapping("/{id}")
    public void deleteEquipe(@PathVariable Long id) {
        equipeRepository.deleteById(id);
    }
}

