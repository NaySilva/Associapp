package br.edu.ifpi.associapp.enuns;

public enum TipoDeComunidadeEnum {

	BAIRRO(1),
	POVOADO(2);
	
	private int id;

	private TipoDeComunidadeEnum(int id) {
		this.id = id;
	}
	public int getId(){
		return id;
	}
	public static TipoDeComunidadeEnum fromInteger(int i){
		if (i == 1){
			return TipoDeComunidadeEnum.BAIRRO;
		}else{
			return TipoDeComunidadeEnum.POVOADO;
		}
	}

}
