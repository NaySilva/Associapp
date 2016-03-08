package br.edu.ifpi.associapp.modelo;

import br.edu.ifpi.associapp.enuns.TipoDeBemEnum;

public class Bens {
	
	private String nome;
	private TipoDeBemEnum tipo;
	private int situacao;
	
	

	public Bens(String nome, TipoDeBemEnum tipo, int situacao) {
		this.nome = nome;
		this.tipo = tipo;
		this.situacao = situacao;
	}
	
	@Override
	public String toString() {
		return this.nome + " (" + this.tipo + ") " + "[Situacao: " + this.situacao + "]";
	}
}
