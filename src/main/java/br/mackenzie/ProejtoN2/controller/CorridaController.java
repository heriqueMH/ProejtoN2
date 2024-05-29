package br.mackenzie.ProejtoN2.controller;

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

import br.mackenzie.ProejtoN2.model.Corrida;
import br.mackenzie.ProejtoN2.repository.CorridaRepository;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/corridas")
public class CorridaController {

    @Autowired
    private CorridaRepository corridaRepository;

    @GetMapping
    public Iterable<Corrida> listarTodasCorridas() {
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
    public ResponseEntity<List<Corrida>> buscarPorCidade(@RequestParam(name = "cidade") String cidade) {
        List<Corrida> corridas = corridaRepository.findByCidadeNome(cidade);
        if (corridas.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(corridas);
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
