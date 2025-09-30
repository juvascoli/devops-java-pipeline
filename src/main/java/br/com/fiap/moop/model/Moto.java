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
    @Enumerated(EnumType.STRING)
    private EnumModelo modelo;

    @NotNull
    @Enumerated(EnumType.STRING)
    private EnumStatus status;
    
    @ManyToOne
    @JoinColumn(name = "id_galpao")
    private Galpao galpao;

}
