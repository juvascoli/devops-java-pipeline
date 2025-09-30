package br.com.fiap.moop.DTO;

import java.util.List;

import lombok.Data;

@Data
public class GalpaoDTO {
	private String nome;
    private Long id;
    private String localizacao;
    private int capacidade;
    private int motosOcupadas; 
    private List<MotoDTO> motos;

}
