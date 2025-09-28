package br.com.fiap.moop.DTO;

import lombok.Data;

@Data
public class GalpaoDTO {
	private String nome;
    private Long id;
    private String localizacao;
    private int capacidade;
    private int motosOcupadas; 
}
