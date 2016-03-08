package br.edu.ifpi.associapp.modelo;

public class Parentesco {
	
	private Pessoa parente;
	private TipoParentesco tipo;
	
	public Parentesco() {
		// TODO Auto-generated constructor stub
	}
	public Pessoa getParente() {
		return parente;
	}
	public void setParente(Pessoa parente) {
		this.parente = parente;
	}
	public TipoParentesco getTipo() {
		return tipo;
	}
	public void setTipo(TipoParentesco tipo) {
		this.tipo = tipo;
	}

}
