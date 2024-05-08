package br.mackenzie.ProejtoN2.controller;

import br.mackenzie.ProejtoN2.model.Pais;
import br.mackenzie.ProejtoN2.repository.PaisRepository;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/paiss")
public class PaisController {

    @Autowired
    private PaisRepository paisRepository;

    @GetMapping
    public Iterable<Pais> listarTodospaiss() {
        return paisRepository.findAll();
    }

    @PostMapping
    public Pais criarpais(@RequestBody Pais pais) {
        return paisRepository.save(pais);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pais> obterpaisPorId(@PathVariable Long id) {
        return paisRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/cidades")
    public String getBuscaCidade(@RequestParam(name = "texto") String texto) {
        return "Texto recebido: " + texto;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pais> atualizarpais(@PathVariable Long id, @RequestBody Pais paisDetalhes) {
        return paisRepository.findById(id)
                .map(pais -> {
                    pais.setNome(paisDetalhes.getNome());
                    pais.setContinente(paisDetalhes.getContinente());
                    pais.setPopulacao(paisDetalhes.getPopulacao());
                    pais.setCidades(paisDetalhes.getCidades());
                    return ResponseEntity.ok(paisRepository.save(pais));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarpais(@PathVariable Long id) {
        return paisRepository.findById(id)
                .map(pais -> {
                    paisRepository.delete(pais);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
