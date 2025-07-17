package br.edu.ifsuldeminas.mch.springbootcrud.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Motorista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "O nome não pode ser vazio.")
    private String nome;

    @NotBlank(message = "O CPF não pode ser vazio.")
    @CPF(message = "CPF inválido.")
    private String cpf;

    @NotBlank(message = "A CNH não pode ser vazia.")
    @Pattern(regexp="[0-9]{11}", message="A CNH deve conter 11 dígitos.")
    private String cnh;

    @Past(message = "A data de nascimento deve ser no passado.")
    private LocalDate dataNascimento;
    
    @OneToMany(mappedBy = "motorista", cascade = CascadeType.ALL)
    private List<Veiculo> veiculos;

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }
}

