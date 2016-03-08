package br.edu.ifpi.associapp.enuns;

public enum ReligiaoEnum{
	
	CATOLICO("Catolico"), EVANGELICO("Evangelico"), SEMRELIGIAO("Sem Religiao"), HINDU("Hindu"), BUDISTA("Budista"), ANIMISTA("Animista"), JUDEU("Judeu"), ESPIRISTIMO("Espiritismo"), OUTROS("Outro");
	private String valorEnum;
	ReligiaoEnum(String valor){
		setValorEnum(valor);
	}
	public String getValorEnum() {
		return valorEnum;
	}
	public void setValorEnum(String valorEnum) {
		this.valorEnum = valorEnum;
	}
}
