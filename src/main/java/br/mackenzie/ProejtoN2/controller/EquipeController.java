package br.mackenzie.ProejtoN2.controller;

import br.mackenzie.ProejtoN2.model.Equipe;
import br.mackenzie.ProejtoN2.model.Piloto;
import br.mackenzie.ProejtoN2.model.Carro;
import br.mackenzie.ProejtoN2.repository.EquipeRepository;
import br.mackenzie.ProejtoN2.repository.PilotoRepository;
import br.mackenzie.ProejtoN2.repository.CarroRepository;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipes")
public class EquipeController {

    @Autowired
    private EquipeRepository equipeRepository;

    @Autowired
    private PilotoRepository pilotoRepository;

    @Autowired
    private CarroRepository carroRepository;

    @GetMapping
    public Iterable<Equipe> listarTodasEquipes() {
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

    // @GetMapping("/{id}/pilotos")
    // public ResponseEntity<List<Piloto>> getPilotosDaEquipe(@PathVariable Long id) {
    //     return ResponseEntity.ok(pilotoRepository.findByEquipeId(id));
    // }

    // @GetMapping("/{id}/carros")
    // public ResponseEntity<List<Carro>> getCarrosDaEquipe(@PathVariable Long id) {
    //     return ResponseEntity.ok(carroRepository.findByEquipeId(id));
    // }

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
