package br.com.fiap.Checkpoint1.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.Email;

@Data
@Entity
@Table(name = "TB_USUARIO")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    @Email
    private String email;

    @Column(nullable = false, length = 11, unique = true)
    @CPF
    private String cpf;

    @OneToMany(mappedBy = "usuarioApartamento", cascade = CascadeType.ALL)
    private List<Apartamento> apartamentos;
    public List<Apartamento> getApartamentos() {
        return apartamentos;
    }


    @OneToMany(mappedBy = "usuarioCarro", cascade = CascadeType.ALL)
    private List<Carro> carros;
    public List<Carro> getCarros() {
        return carros;
    }







}
