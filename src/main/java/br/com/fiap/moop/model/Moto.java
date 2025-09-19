package br.com.fiap.moop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
@Entity
@Table(name = "moto")
public class Moto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_moto")
    private Long id;

    @NotBlank
    private String placa;

    @NotBlank
    private String chassi;

    @NotBlank
    private String modelo;

    @NotNull
    @Enumerated(EnumType.STRING)
    private EnumStatus status;

    // Relacionamento com Galpão
    @ManyToOne
    @JoinColumn(name = "galpao_id")
    private Galpao galpao;

}