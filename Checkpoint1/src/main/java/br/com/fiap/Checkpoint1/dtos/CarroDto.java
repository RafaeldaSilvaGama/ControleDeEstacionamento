package br.com.fiap.Checkpoint1.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public class CarroDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotBlank(message = "Placa é obrigatório")
    @Size(max = 7, min = 7, message = "Placa precisa ter 7 caracteres")
    private String placa;

    @NotBlank(message = "Modelo obrigatório")
    @Size(max = 100, message = "Tamanho máximo do campo modelo de 100 caracteres")
    private String modelo;

    @NotBlank(message = "Cor obrigatória")
    @Size(max = 20, message = "Tamanho máximo do campo cor de 20 caracteres")
    private String cor;


    @NotBlank(message = "Ano obrigatório")
    @Size(max = 4, min = 4, message = "Tamanho máximo do campo ano de 4 caracteres")
    private String ano;

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
}
