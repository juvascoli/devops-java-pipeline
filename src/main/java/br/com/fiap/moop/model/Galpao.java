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

    private String nome;

    private String localizacao;

    private int capacidade;

    @Column(name = "motos_ocupadas")
    private int motosOcupadas;

    @OneToMany(mappedBy = "galpao", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Moto> motos;

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
