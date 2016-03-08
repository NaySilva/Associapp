package br.edu.ifpi.associapp.enuns;

public enum CargoEnum {
	
	PRESIDENTE(1),
	VICE_PRESIDENTE(2),
	TESOREIRO(3),
	SECREARIO(4);
	
	private int id;

	private CargoEnum(int id) {
		this.id = id;
	}
	public int getId(){
		return id;
	}
	

}
