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
import br.mackenzie.ProejtoN2.model.Pais;
import br.mackenzie.ProejtoN2.repository.PaisRepository;
import br.mackenzie.ProejtoN2.repository.CidadeRepository;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pais")
public class PaisController {

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

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

    @GetMapping("/{id}/cidades")
    public ResponseEntity<List<Cidade>> getCidadesPeloPais(@PathVariable Long id) {
        return ResponseEntity.ok(cidadeRepository.findByPaisId(id));
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
