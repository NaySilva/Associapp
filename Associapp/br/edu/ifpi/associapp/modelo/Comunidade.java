package br.edu.ifpi.associapp.modelo;

import java.util.*;

import br.edu.ifpi.associapp.enuns.TipoDeComunidadeEnum;
import br.edu.ifpi.associapp.enuns.ZonaEnum;

public class Comunidade {

	private String nome;
	private int idadeMinimaLider;
	private TipoDeComunidadeEnum tipo;
	private String cidade;
	private String regiao;
	private ZonaEnum zona;
	private int indiceDeSeguranca;
	private Coordenadas coordenadas;
	private String historico;
	private int codigo;
	private List<Familia> familias = new ArrayList<>();
	private List<AptidoesProdutivas> aptidoesProdutivas = new ArrayList<>();
	private List<Bens> bens = new ArrayList<>();
	

	
	public Comunidade() {
	}
	
	public Comunidade(String nome, TipoDeComunidadeEnum tipo, Endereco endereco, int ids,
			Coordenadas coordenadas) {
		this.nome = nome;
		this.tipo = tipo;
		this.indiceDeSeguranca = ids;
		this.coordenadas = coordenadas;
	}
	
//	private String geraCodigo(String nome){
//		String inicio = nome.substring(0, 3).toUpperCase();
//		int fim = (int)(Math.random()*1000);
//		String cod = inicio + fim;
//		return cod;
//	}
	
	public void addFamilias(Familia familia){
		this.familias.add(familia);
	}
	
	public void addBens(Bens bem){
		this.bens.add(bem);
	}
	
	public void addAptidoesProdutivas(AptidoesProdutivas aptidoesProdutivas){
		this.aptidoesProdutivas.add(aptidoesProdutivas);
	}
	
	
	
	public void mostraListaDeBens(){
		for (Bens bem : bens) {
			System.out.println(bem);
		}
	}

	public void mostraListaDeAptidoesProdutivas(){
		for (AptidoesProdutivas aptidoesProdutivas : aptidoesProdutivas) {
			System.out.println(aptidoesProdutivas);
		}
	}

	
	public void setCoordenadas(Coordenadas coordenadas){
		this.coordenadas = coordenadas;
	}
	
	@Override
	public String toString() {
		String str = this.codigo + " - Nome da comunidade: " + this.nome + " (" + this.tipo + ")\n";
		return str;
	}

	public int getIdadeMinimaLider() {
		return this.idadeMinimaLider;
	}

	public TipoDeComunidadeEnum getTipo() {
		return tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setCodigo(int id) {
		this.codigo = id;
		
	}

	public void setNome(String nome) {
		this.nome = nome;
		
	}

	public void setIdadeMinimaLider(int idade) {
		this.idadeMinimaLider = idade;
		
	}

	public void setTipo(TipoDeComunidadeEnum tipo) {
		this.tipo = tipo;
	}

	public int getCodigo() {
		return codigo;
	}

	
}

