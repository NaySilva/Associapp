package br.edu.ifpi.associapp.enuns;

public enum TimeDeFutebolEnum{
	
	FLAMENGO("Flamengo"), FLUMINENSE("Fluminense"), CORINTHIANS("Corinthians"),
	ATLETICOMG("Atletico-MG"), VASCO("Vasco"), BOTAFOGO("Botafogo"), 
	GREMIO("Gremio"), SANTOS("Santos"),	CRUZEIRO("Cruzeiro"), PALMEIRAS("Palmeiras"),
	INTERNACIONAL("Internaconal"), SAOPAULO("São Paulo"), OUTROS("Outro");
	private String valorEnum;
	TimeDeFutebolEnum(String valor){
		setValorEnum(valor);
	}
	public String getValorEnum() {
		return valorEnum;
	}
	public void setValorEnum(String valorEnum) {
		this.valorEnum = valorEnum;
	}
}