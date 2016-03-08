package br.edu.ifpi.associapp.modelo;

public class Parentesco {
	
	private Membro parente;
	private TipoParentesco tipo;
	
	public Parentesco() {
		// TODO Auto-generated constructor stub
	}
	public Membro getParente() {
		return parente;
	}
	public void setParente(Membro parente) {
		this.parente = parente;
	}
	public TipoParentesco getTipo() {
		return tipo;
	}
	public void setTipo(TipoParentesco tipo) {
		this.tipo = tipo;
	}

}
