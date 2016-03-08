package br.edu.ifpi.associapp.modelo;

public class TipoParentesco {

	private String nome;
	private TipoParentesco espelho;

	public TipoParentesco getEspelho() {
		return espelho;
	}
	
	public void setEspelho(TipoParentesco espelho) {
		this.espelho = espelho;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
