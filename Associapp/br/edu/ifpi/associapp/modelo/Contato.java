package br.edu.ifpi.associapp.modelo;

public class Contato {

	private String tipo;
	private String descricao;
	
	public Contato(String tipo, String descricao) {
		this.tipo = tipo;
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		return this.tipo + ": " + this.descricao;
	}
}
