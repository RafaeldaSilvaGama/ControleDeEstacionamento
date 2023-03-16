package br.com.fiap.Checkpoint1.model;

import br.com.fiap.Checkpoint1.annotations.Placa;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "TB_CARRO")
public class Carro implements Serializable {
    private static final long serialVertionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Placa
    @Column(nullable = false, length = 7, unique = true)
    private String placa;

    @Column(nullable = false, length = 100)
    private String modelo;

    @Column(nullable = false, length = 20)
    private String cor;

    @Column(length = 4)
    private String ano;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuarioCarro;

    @OneToOne(cascade={CascadeType.DETACH})
    @JoinColumn(name = "vaga_id")
    private Vaga vaga;



}
