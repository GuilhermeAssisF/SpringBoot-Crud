package br.edu.ifsuldeminas.mch.springbootcrud.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "A placa não pode ser vazia.")
    private String placa;

    @NotBlank(message = "A marca não pode ser vazia.")
    private String marca;

    @NotBlank(message = "O modelo não pode ser vazio.")
    private String modelo;

    @NotNull(message = "O ano de fabricação não pode ser nulo.")
    @Min(value = 1980, message = "O ano de fabricação deve ser no mínimo 1980.")
    private int anoFabricacao;

    @ManyToOne
    @JoinColumn(name = "motorista_id")
    private Motorista motorista;
    
    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }
    
    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }
}


