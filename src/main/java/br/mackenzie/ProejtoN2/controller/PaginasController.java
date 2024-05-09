package br.mackenzie.ProejtoN2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

    
@Controller
public class PaginasController {
    
    @GetMapping("/")
    public String home() {
        return "index";
    }
    
}
    

