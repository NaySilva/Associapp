package br.edu.ifpi.associapp.modelo;


import java.util.ArrayList;
import java.util.List;

import br.edu.ifpi.associapp.enuns.SituacaoDaCasaEnum;

public class Familia {
	private Endereco endereco;
	private int codigo;
	private int idComunidade;
	private List<Pessoa> membros = new ArrayList<>();
	private Pessoa chefe;
	private String descricao;
	private SituacaoDaCasaEnum situacaoDaCasa;
	private List<Recursos> recursos = new ArrayList<>();
	private int seguranca;
	
	public Familia() {
		// TODO Auto-generated constructor stub
	}
	
	public Familia(Endereco endereco, String descricao, SituacaoDaCasaEnum situacaoDaCasa, int seguranca) {
		this.endereco = endereco;
		this.descricao = descricao;
		this.situacaoDaCasa = situacaoDaCasa;
		this.seguranca = seguranca;
	}
	
	public void definiChefe(){
		this.chefe = this.membros.get(0);
	}
	
	public void addMembro(Pessoa membro){
		this.membros.add(membro);
	}
	
	public void mostraMembros(){
		for (Pessoa membro : membros) {
			System.out.println(membro);
		}
	}

	public List<Pessoa> getMembros() {
		return membros;
	}

	public String getEndereco() {
		// TODO Auto-generated method stub
		return this.endereco.toString();
	}

	public void setCodigo(int id) {
		this.codigo = id;
		
	}

	public void setEndereco(Endereco end) {
		this.endereco = end;
		
	}

	public int getCodigo() {
		// TODO Auto-generated method stub
		return this.codigo;
	}

	public int getIdComunidade() {
		return idComunidade;
	}

	public void setIdComunidade(int idComunidade) {
		this.idComunidade = idComunidade;
	}

	

//	public void setEndereco(String blob) {
//		this.endereco.toString() = blob;
//		
//	}

	
	
	
//	private String geraCodigo(String nome){
//		String inicio = nome.substring(0, 3).toUpperCase();
//		int fim = (int)(Math.random()*1000);
//		String cod = inicio + fim;
//		return cod;
//	}
}
