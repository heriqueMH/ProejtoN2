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

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

    
@Controller
public class PaginasController {
    
    @GetMapping("index")
    public String home() {
        return "index.html";
    }

    @GetMapping("/equipes")
    public String equipes() {
        return "equipes.html";
    }

    @GetMapping("/carros")
    public String carros() {
        return "carros.html";
    }

    @GetMapping("/corridas")
    public String corridas() {
        return "corridas.html";
    }

    @GetMapping("/pilotos")
    public String pilotos() {
        return "pilotos.html";
    }
    
}
    

