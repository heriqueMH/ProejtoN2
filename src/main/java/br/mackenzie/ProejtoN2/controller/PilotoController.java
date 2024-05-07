package br.mackenzie.ProejtoN2.controller;

import br.mackenzie.ProejtoN2.model.Piloto;
import br.mackenzie.ProejtoN2.repository.PilotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pilotos")
public class PilotoController {

    @Autowired
    private PilotoRepository pilotoRepository;

    @GetMapping
    public List<Piloto> listarTodosPilotos() {
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
