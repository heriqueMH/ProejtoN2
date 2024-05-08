package br.mackenzie.ProejtoN2.controller;

import br.mackenzie.ProejtoN2.model.Piloto;
import br.mackenzie.ProejtoN2.repository.PilotoRepository;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pilotos")
public class PilotoController {

    @Autowired
    private PilotoRepository pilotoRepository;

    @GetMapping
    public Iterable<Piloto> listarTodosPilotos() {
        return pilotoRepository.findAll();
    }

    @PostMapping
    public Piloto criarPiloto(@RequestBody Piloto piloto) {
        return pilotoRepository.save(piloto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Piloto> obterPilotoPorId(@PathVariable Long id) {
        return pilotoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/equipe")
    public ResponseEntity<List<Piloto>> getBuscaEquipePiloto(@RequestParam(name = "nome") String nomeEquipe) {
        List<Piloto> pilotos = pilotoRepository.findByEquipeNome(nomeEquipe);
        if (pilotos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pilotos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Piloto> atualizarPiloto(@PathVariable Long id, @RequestBody Piloto pilotoDetalhes) {
        return pilotoRepository.findById(id)
                .map(piloto -> {
                    piloto.setNome(pilotoDetalhes.getNome());
                    piloto.setNumSuperlicenca(pilotoDetalhes.getNumSuperlicenca());
                    piloto.setDataDeNascimento(pilotoDetalhes.getDataDeNascimento());
                    return ResponseEntity.ok(pilotoRepository.save(piloto));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPiloto(@PathVariable Long id) {
        return pilotoRepository.findById(id)
                .map(piloto -> {
                    pilotoRepository.delete(piloto);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
