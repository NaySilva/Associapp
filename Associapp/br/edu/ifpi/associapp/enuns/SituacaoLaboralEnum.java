package br.edu.ifpi.associapp.enuns;

public enum SituacaoLaboralEnum{
	
	EMPREGADO("Empregado"), EMPRESARIO("Empresario"), 
	DESEMPREGADO("Desempregado"), EMPREENDEDOR("Empreendedor"), 
	PRODUTORRURAL("Produtor Rural"), OUTROS("Outro");
	private String valorEnum;
	SituacaoLaboralEnum(String valor){
		setValorEnum(valor);
	}
	public String getValorEnum() {
		return valorEnum;
	}
	public void setValorEnum(String valorEnum) {
		this.valorEnum = valorEnum;
	}

}
