package br.edu.ifpi.associapp.modelo;

import br.edu.ifpi.associapp.enuns.TipoDeAptidaoEnum;

public class AptidoesProdutivas {

	private String nome;
	private TipoDeAptidaoEnum tipo;
	
	
	
	public AptidoesProdutivas(String nome, TipoDeAptidaoEnum tipo){
		this.nome = nome;
		this.tipo = tipo;
	}
	
	@Override
	public String toString(){
		return this.nome + " (" + this.tipo + ")";
	}
}
