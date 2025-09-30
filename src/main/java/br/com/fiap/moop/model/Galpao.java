package br.com.fiap.moop.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

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
    
    @PositiveOrZero (message="O valor de capacidade não pode ser negativo")
    private int capacidade;

    @PositiveOrZero (message="O valor de motos ocupadas não pode ser negativo")
    @Column(name = "motos_ocupadas")
    private int motosOcupadas;
    
    @OneToMany(mappedBy = "galpao", cascade = CascadeType.ALL, orphanRemoval = true)
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
