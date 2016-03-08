package br.edu.ifpi.associapp.modelo;

public class Coordenadas {
	private double latitude;
	private	double longitude;
	
	public Coordenadas(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	@Override
	public String toString() {
		return this.latitude + "|" + this.longitude;
	}
}
