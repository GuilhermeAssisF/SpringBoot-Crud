package br.edu.ifsuldeminas.mch.springbootcrud.controller;

import br.edu.ifsuldeminas.mch.springbootcrud.model.entity.Motorista;
import br.edu.ifsuldeminas.mch.springbootcrud.model.repository.MotoristaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired; // <--- IMPORT NECESSÁRIO
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
 

import java.util.List;
import java.util.Optional;

@Controller
public class MotoristaController {

    // A INJEÇÃO DE DEPENDÊNCIA ESTAVA FALTANDO AQUI
    @Autowired
    private MotoristaRepository motoristaRepository;

    @GetMapping("/motoristas")
    public String listarMotoristas(Model model) {
        List<Motorista> motoristas = motoristaRepository.findAll();
        model.addAttribute("motoristas", motoristas);
        model.addAttribute("currentPage", "motoristas"); // Adicione esta linha
        return "motorista";
    }


    @GetMapping("/motoristas/form")
    public String exibirFormularioMotorista(@ModelAttribute("motorista") Motorista motorista) {
        return "motorista_form";
    }

    @PostMapping("/motoristas/new")
    public String salvarMotorista(@Valid @ModelAttribute("motorista") Motorista motorista, BindingResult validationResult) {
        if (validationResult.hasErrors()) {
            return "motorista_form";
        }
        motoristaRepository.save(motorista);
        return "redirect:/motoristas";
    }

    @GetMapping("/motoristas/update/{id}")
    public String editarMotorista(@PathVariable("id") Integer id, Model model) {
        Optional<Motorista> motoristaOpt = motoristaRepository.findById(id);
        if (motoristaOpt.isEmpty()) {
            throw new IllegalArgumentException("Motorista inválido.");
        }
        model.addAttribute("motorista", motoristaOpt.get());
        return "motorista_form";
    }

    @GetMapping("/motoristas/delete/{id}")
    public String deletarMotorista(@PathVariable("id") Integer id) {
        Optional<Motorista> motoristaOpt = motoristaRepository.findById(id);
        if (motoristaOpt.isPresent()) {
            motoristaRepository.delete(motoristaOpt.get());
        } else {
            throw new IllegalArgumentException("Motorista inválido para exclusão.");
        }
        return "redirect:/motoristas";
    }
}
