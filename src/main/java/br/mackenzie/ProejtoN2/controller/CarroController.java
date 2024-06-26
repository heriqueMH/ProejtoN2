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

import br.mackenzie.ProejtoN2.model.Carro;
import br.mackenzie.ProejtoN2.repository.CarroRepository;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carros")
public class CarroController {

    @Autowired
    private CarroRepository carroRepository;

    @GetMapping
    public Iterable<Carro> listarTodascarros() {
        return carroRepository.findAll();
    }

    @PostMapping
    public Carro criarcarro(@RequestBody Carro carro) {
        return carroRepository.save(carro);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carro> obtercarroPorId(@PathVariable Long id) {
        return carroRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/por-equipe")
    public ResponseEntity<List<Carro>> buscarPorNomeEquipe(@RequestParam("nome") String nomeEquipe) {
        List<Carro> carros = carroRepository.findByEquipeNome(nomeEquipe);
        if(carros.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(carros);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carro> atualizarcarro(@PathVariable Long id, @RequestBody Carro detalhescarro) {
        return carroRepository.findById(id)
                .map(carro -> {
                    carro.setModelo(detalhescarro.getModelo());
                    carro.setMarca(detalhescarro.getMarca());
                    carro.setAno(detalhescarro.getAno());
                    carro.setCategoria(detalhescarro.getCategoria());
                    carro.setEquipe(detalhescarro.getEquipe());
                    return ResponseEntity.ok(carroRepository.save(carro));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarcarro(@PathVariable Long id) {
        return carroRepository.findById(id)
                .map(carro -> {
                    carroRepository.delete(carro);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}

