package br.com.fiap.Checkpoint1.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public class ApartamentoDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotBlank(message = "Número é obrigatório")
    @Size(max = 4, message = "Número precisa ter no máximo 4 caracteres")
    private String numero;

    @NotBlank(message = "Andar é obrigatório")
    @Size(max = 2, message = "Andar precisa ter no máximo 2 caracteres")
    private String andar;

    @NotBlank(message = "Bloco é obrigatório")
    @Size(max = 5, message = "Andar precisa ter no máximo 5 caracteres")
    private String bloco;

    @NotBlank(message = "Andar é obrigatório")
    @Size(max = 2, message = "Predio precisa ter no máximo 2 caracteres")
    private String predio;

    @NotNull(message = "Id obrigatório")
    private long usuarioApartamento;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getAndar() {
        return andar;
    }

    public void setAndar(String andar) {
        this.andar = andar;
    }

    public String getBloco() {
        return bloco;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }

    public String getPredio() {
        return predio;
    }

    public void setPredio(String predio) {
        this.predio = predio;
    }

    public long getUsuarioApartamento() {
        return usuarioApartamento;
    }

    public void setUsuarioApartamento(long usuario_id) {
        this.usuarioApartamento = usuario_id;
    }
}
