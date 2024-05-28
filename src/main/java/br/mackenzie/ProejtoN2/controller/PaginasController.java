package br.mackenzie.ProejtoN2.controller;

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
    

