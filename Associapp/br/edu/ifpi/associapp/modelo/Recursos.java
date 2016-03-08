package br.edu.ifpi.associapp.modelo;

public class Recursos {
	
	private String nome;
	private String descricao;
	
	public Recursos(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		return this.nome + ", " + this.descricao;
	}

}
