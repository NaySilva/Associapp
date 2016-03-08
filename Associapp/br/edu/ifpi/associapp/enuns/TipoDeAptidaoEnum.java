package br.edu.ifpi.associapp.enuns;

public enum TipoDeAptidaoEnum {
	
	BAR(1),
	HORTA(2),
	CORMECIO(3),
	OUTRO(4);
	
	private int id;

	private TipoDeAptidaoEnum(int id) {
		this.id = id;
	}
	public int getId(){
		return id;
	}
	public static TipoDeAptidaoEnum fromInteger(int i){
		if (i == 1){
			return TipoDeAptidaoEnum.BAR;
		}else if (i == 2){
			return TipoDeAptidaoEnum.HORTA;
		}else if (i ==3){
			return TipoDeAptidaoEnum.CORMECIO;
		}else{
			return TipoDeAptidaoEnum.OUTRO;
		}
	}

}
