package br.edu.ifpi.associapp.modelo;

import br.edu.ifpi.associapp.enuns.CargoEnum;

public class Membro {
	
	private String nome;
	private CargoEnum cargo;
	private String formaDeDefiniçao;


	public String toString() {
		return "Gestor [Nome: " + nome + ", Cargo: " + cargo + ", Forma De Definiçao: " + formaDeDefiniçao + "]\n";
	}
	
	

}
