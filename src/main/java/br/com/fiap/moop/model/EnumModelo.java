package br.com.fiap.moop.model;

public enum EnumModelo {
	
	MOTTUSPORT("Mottusport"), MOTTUE("Mottue"), MOTTUPOP("Mottupop");

	private final String descricao;

	private EnumModelo(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}


}
