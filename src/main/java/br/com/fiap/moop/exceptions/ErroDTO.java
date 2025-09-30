package br.com.fiap.moop.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErroDTO {
	
	 private String mensagem;
	 private String campo;

}
