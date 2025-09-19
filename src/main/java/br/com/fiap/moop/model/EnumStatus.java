package br.com.fiap.moop.model;

public enum EnumStatus {

	ATIVA("Ativa"), INATIVA("Inativa"), MANUTENCAO("Manutencao");

	private final String descricao;

	private EnumStatus(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
