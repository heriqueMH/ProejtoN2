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

import br.mackenzie.ProejtoN2.model.Cidade;
import br.mackenzie.ProejtoN2.repository.CidadeRepository;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cidades")
public class CidadeController {

    @Autowired
    private CidadeRepository cidadeRepository;

    @GetMapping
    public Iterable<Cidade> listarTodascidades() {
        return cidadeRepository.findAll();
    }

    @PostMapping
    public Cidade criarcidade(@RequestBody Cidade cidade) {
        return cidadeRepository.save(cidade);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cidade> obtercidadePorId(@PathVariable Long id) {
        return cidadeRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/populacao")
    public ResponseEntity<List<Cidade>> getCidadesPorPopulacao(@RequestParam(name = "minima") Long populacaoMinima) {
        List<Cidade> cidades = cidadeRepository.findByPopulacaoGreaterThanEqual(populacaoMinima);
        if (cidades.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cidades);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cidade> atualizarcidade(@PathVariable Long id, @RequestBody Cidade detalhescidade) {
        return cidadeRepository.findById(id)
                .map(cidade -> {
                    cidade.setNome(detalhescidade.getNome());
                    cidade.setEstado(detalhescidade.getEstado());
                    cidade.setPopulacao(detalhescidade.getPopulacao());
                    cidade.setCorridas(detalhescidade.getCorridas());
                    return ResponseEntity.ok(cidadeRepository.save(cidade));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarcidade(@PathVariable Long id) {
        return cidadeRepository.findById(id)
                .map(cidade -> {
                    cidadeRepository.delete(cidade);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
