package br.edu.ifpi.associapp.enuns;

public enum TipoDeBemEnum {

	QUADRA(1),
	LAVANDERIA(2), 
	PRACA(3), 
	HOSPITAL(4),
	SISTEMADEABASTECIMENTODEAGUA(5),
	ILUMINACAOPUBLICA(6),
	OUTRO(7);
	
	private int id;

	private TipoDeBemEnum(int id) {
		this.id = id;
	}
	public int getId(){
		return id;
	}
	public static TipoDeBemEnum fromInteger(int i){
		if (i == 1){
			return TipoDeBemEnum.QUADRA;
		}else if (i == 2){
			return TipoDeBemEnum.LAVANDERIA;
		}else if (i == 3){
			return TipoDeBemEnum.PRACA;
		}else if (i ==4){
			return TipoDeBemEnum.HOSPITAL;
		}else if (i == 5){
			return TipoDeBemEnum.SISTEMADEABASTECIMENTODEAGUA;
		}else if (i == 6){
			return TipoDeBemEnum.ILUMINACAOPUBLICA;
		}else{
			return TipoDeBemEnum.OUTRO;
		}
	}
	
}
