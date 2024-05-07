package br.mackenzie.ProejtoN2.controller;

import br.mackenzie.ProejtoN2.model.Carro;
import br.mackenzie.ProejtoN2.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carros")
public class CarroController {

    @Autowired
    private CarroRepository carroRepository;

    @GetMapping
    public List<Carro> listarTodascarros() {
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

