package br.com.fiap.Checkpoint1.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public class UsuarioDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotBlank(message = "Nome obrigatório")
    private String name;

    @NotBlank(message = "Email obrigatório")
    private String email;

    @NotBlank(message = "CPF obrigatório")
    @Size(max = 11, min = 11, message = "CPF precisa ter 11 caracteres")
    private String cpf;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
