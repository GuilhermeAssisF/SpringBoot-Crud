package br.edu.ifsuldeminas.mch.springbootcrud.controller;

import br.edu.ifsuldeminas.mch.springbootcrud.model.entity.Motorista;
import br.edu.ifsuldeminas.mch.springbootcrud.model.entity.Veiculo;
import br.edu.ifsuldeminas.mch.springbootcrud.model.repository.MotoristaRepository;
import br.edu.ifsuldeminas.mch.springbootcrud.model.repository.VeiculoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
public class VeiculoController {

    @Autowired
    private VeiculoRepository veiculoRepository;
    
    @Autowired
    private MotoristaRepository motoristaRepository;

    @GetMapping("/veiculos")
    public String veiculos(Model model) {
        List<Veiculo> veiculos = veiculoRepository.findAll();
        model.addAttribute("veiculos", veiculos);
        model.addAttribute("currentPage", "veiculos");
        return "veiculo";
    }

    @GetMapping("/veiculos/form")
    public String veiculoForm(@ModelAttribute("veiculo") Veiculo veiculo, Model model) {
        List<Motorista> motoristas = motoristaRepository.findAll();
        model.addAttribute("motoristas", motoristas);
        return "veiculo_form";
    }

    @PostMapping("/veiculos/new")
    public String veiculoSave(@Valid @ModelAttribute("veiculo") Veiculo veiculo, BindingResult validationResult, Model model) {
        if (validationResult.hasErrors()) {
            List<Motorista> motoristas = motoristaRepository.findAll();
            model.addAttribute("motoristas", motoristas);
            return "veiculo_form";
        }
        veiculoRepository.save(veiculo);
        return "redirect:/veiculos";
    }

    @GetMapping("/veiculos/update/{id}")
    public String veiculoUpdate(@PathVariable("id") Integer id, Model model) {
        Optional<Veiculo> optVeiculo = veiculoRepository.findById(id);
        if (optVeiculo.isEmpty()) {
            throw new IllegalArgumentException("Veículo inválido.");
        }
        model.addAttribute("veiculo", optVeiculo.get());
        
        List<Motorista> motoristas = motoristaRepository.findAll();
        model.addAttribute("motoristas", motoristas);
        
        return "veiculo_form";
    }

    @GetMapping("/veiculos/delete/{id}")
    public String veiculoDelete(@PathVariable("id") Integer id) {
        Optional<Veiculo> optVeiculo = veiculoRepository.findById(id);
        if (optVeiculo.isEmpty()) {
            throw new IllegalArgumentException("Veículo inválido.");
        }
        veiculoRepository.delete(optVeiculo.get());
        return "redirect:/veiculos";
    }
}

