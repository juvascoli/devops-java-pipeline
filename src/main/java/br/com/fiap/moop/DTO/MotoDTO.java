package br.com.fiap.moop.DTO;

import lombok.Data;

@Data
public class MotoDTO {
    private Long id;
    private String placa;
    private String chassi;
    private String modelo;
    private String status;
    private Long galpaoId;
}

