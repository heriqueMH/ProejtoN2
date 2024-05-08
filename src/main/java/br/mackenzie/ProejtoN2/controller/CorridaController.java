package br.mackenzie.ProejtoN2.controller;

import br.mackenzie.ProejtoN2.model.Corrida;
import br.mackenzie.ProejtoN2.repository.CorridaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/corridas")
public class CorridaController {

    @Autowired
    private CorridaRepository corridaRepository;

    @GetMapping
    public List<Corrida> listarTodasCorridas() {
        return corridaRepository.findAll();
    }

    @PostMapping
    public Corrida criarCorrida(@RequestBody Corrida corrida) {
        return corridaRepository.save(corrida);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Corrida> obterCorridaPorId(@PathVariable Long id) {
        return corridaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/cidade")
    public String getBuscaCidadeCorrida(@RequestParam(name = "texto") String texto) {
        return "Texto recebido: " + texto;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Corrida> atualizarCorrida(@PathVariable Long id, @RequestBody Corrida detalhesCorrida) {
        return corridaRepository.findById(id)
                .map(corrida -> {
                    corrida.setNome(detalhesCorrida.getNome());
                    corrida.setData(detalhesCorrida.getData());
                    corrida.setCircuito(detalhesCorrida.getCircuito());
                    corrida.setCondicoesClimaticas(detalhesCorrida.getCondicoesClimaticas());
                    corrida.setCidade(detalhesCorrida.getCidade());
                    return ResponseEntity.ok(corridaRepository.save(corrida));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCorrida(@PathVariable Long id) {
        return corridaRepository.findById(id)
                .map(corrida -> {
                    corridaRepository.delete(corrida);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
