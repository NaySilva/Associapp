package br.edu.ifpi.associapp.modelo;

public class Endereco {
	
	private String rua;
	private int numero;
	private String complemento;
	private String cep;
	
	
	

	
	public Endereco(String rua, int numero, String cep){
		this.setRua(rua);
		this.setNumero(numero);
		this.setCep(cep);
	}

	public Endereco(String rua, int numero, String complemento, String cep) {
		this.setRua(rua);
		this.setNumero(numero);
		this.setComplemento(complemento);
		this.setCep(cep);
	}
	
	public Endereco() {
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		if (this.getComplemento() == null){
			return this.getRua() + ", N.º " + this.getNumero() + ", CEP " + this.getCep(); 
		} else{
			return this.getRua() + ", N.º " + this.getNumero() + ", CEP " + this.getCep() + " (" + this.getComplemento() + ")"; 
		}
		
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	
}
