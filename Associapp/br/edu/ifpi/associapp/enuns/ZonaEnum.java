package br.edu.ifpi.associapp.enuns;

public enum ZonaEnum {
	BAIRRO(1),
	POVOADO(2),
	OUTRO(3);
	
	private int id;

	private ZonaEnum(int id) {
		this.id = id;
	}
	public int getId(){
		return id;
	}
	public static ZonaEnum fromInteger(int i){
		if (i == 1){
			return ZonaEnum.BAIRRO;
		}else if (i == 2){
			return ZonaEnum.POVOADO;
		}else {
			return ZonaEnum.OUTRO;
		}
	}

}
