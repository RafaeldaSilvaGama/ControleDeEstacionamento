package br.com.fiap.Checkpoint1.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public class VagaDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "Número é obrigatório")
    private int numero;

    @NotBlank(message = "Andar da garagem é obrigatório")
    @Size(max = 2, message = "Andar da garagem precisa ter no máximo 2 caracteres")
    private String andarGaragem;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getAndarGaragem() {
        return andarGaragem;
    }

    public void setAndarGaragem(String andarGaragem) {
        this.andarGaragem = andarGaragem;
    }
}
