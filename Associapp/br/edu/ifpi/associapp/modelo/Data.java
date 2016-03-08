package br.edu.ifpi.associapp.modelo;



public class Data {
	
	private int dia;
	private int mes;
	private int ano;
	
	public Data(int ano){
		this.ano = ano;
	}
	
	public Data(int mes, int ano){
		this.mes = mes;
		this.ano = ano;
	}
	
	public Data(int dia, int mes, int ano){
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}
	
	@Override
	public String toString() {
		if (this.dia == 0){
			if (this.mes == 0){
				return String.valueOf(ano);
			}
			return this.mes + "/" + this.ano;
		} else {
			return this.dia + "/" + this.mes + "/" + this.ano;
		}
	}
}
