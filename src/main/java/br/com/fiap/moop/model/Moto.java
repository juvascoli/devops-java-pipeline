package br.com.fiap.moop.model;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
@Entity
public class Moto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String placa;

    @NotBlank
    private String chassi;

    @NotBlank
    private String modelo;

    @NotNull
    private Status status;

    // Relacionamento com Galpão
    @ManyToOne
    @JoinColumn(name = "galpao_id")
    private Galpao galpao;

    public enum Status {
        DISPONIVEL,
        OCUPADA,
        MANUTENCAO
    }
}