package br.com.fiap.moop.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "galpao")
public class Galpao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_galpao")
    private Long id;

    private String localizacao; // Local onde o galpão está situado

    private int capacidade; // Capacidade total do galpão

    @Column(name = "motos_ocupadas")
    private int motosOcupadas; // Número de motos atualmente armazenadas

    @OneToMany(mappedBy = "galpao", cascade = CascadeType.ALL)
    private List<Moto> motos; // Lista de motos armazenadas neste galpão

    public boolean podeAdicionarMoto() {
        return motosOcupadas < capacidade;
    }

    public void adicionarMoto() {
        if (podeAdicionarMoto()) {
            motosOcupadas++;
        } else {
            throw new RuntimeException("Capacidade do galpão atingida");
        }
    }

    public void removerMoto() {
        if (motosOcupadas > 0) {
            motosOcupadas--;
        }
    }
}