package br.edu.ifsuldeminas.mch.springbootcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
    public String index(Model model) { // Adicione Model
        model.addAttribute("currentPage", "home"); // Adicione esta linha
        return "index";
    }
}


