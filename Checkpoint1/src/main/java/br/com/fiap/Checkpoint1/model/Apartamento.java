package br.com.fiap.Checkpoint1.model;


import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "TB_APARTAMENTO")
public class Apartamento  implements Serializable {
    private static final long serialVertionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 4)
    private int numero;

    @Column(nullable = false, length = 2)
    private int andar;

    @Column(nullable = false, length = 5)
    private String bloco;

    @Column(nullable = false, length = 2)
    private String predio;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuarioApartamento;

    @OneToOne(cascade={CascadeType.DETACH})
    @JoinColumn(name = "vaga_id")
    private Vaga vaga;



}
