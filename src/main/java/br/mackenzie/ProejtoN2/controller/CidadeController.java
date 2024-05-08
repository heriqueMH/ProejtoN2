package br.mackenzie.ProejtoN2.controller;

import br.mackenzie.ProejtoN2.model.Cidade;
import br.mackenzie.ProejtoN2.repository.CidadeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public String getBuscaPopulacao(@RequestParam(name = "texto") String texto) {
        return "Texto recebido: " + texto;
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
