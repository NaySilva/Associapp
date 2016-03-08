package br.edu.ifpi.associapp.modelo;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpi.associapp.enuns.GrauDeInstucaoEnum;
import br.edu.ifpi.associapp.enuns.ReligiaoEnum;
import br.edu.ifpi.associapp.enuns.SituacaoLaboralEnum;
import br.edu.ifpi.associapp.enuns.TimeDeFutebolEnum;

public class Membro {

	private int id;
	private String nome;
	private Data dataDeNascimento;
	private char sexo;
	private String profissao;
	private SituacaoLaboralEnum situacaoLaboral;
	private double rendaMediaMensal;
	private ReligiaoEnum religiao;
	private TimeDeFutebolEnum timeDeFutebol;
	private GrauDeInstucaoEnum grauDeInstrucao;
	private List<Contato> contatos = new ArrayList<>();
	private List<Parentesco> parentescos;
	
	
	public Membro(String nome, Data dataDeNascimento, char sexo, String profissao, SituacaoLaboralEnum situacaoLaboral, double rendaMediaMensal,
			ReligiaoEnum religiao, TimeDeFutebolEnum timeDeFutebol, GrauDeInstucaoEnum grauDeInstrucao) {
		this.setNome(nome);
		this.dataDeNascimento = dataDeNascimento;
		this.setSexo(sexo);
		this.profissao = profissao;
		this.situacaoLaboral = situacaoLaboral;
		this.setRendaMediaMensal(rendaMediaMensal);
		this.setReligiao(religiao);
		this.timeDeFutebol = timeDeFutebol;
		this.grauDeInstrucao = grauDeInstrucao;
	}
	
	public Membro() {
		// TODO Auto-generated constructor stub
	}

	public void addContato(Contato contato){
		this.contatos.add(contato);
	}
	
	public void mostraContatos(){
		for (Contato contato : contatos) {
			System.out.println(contato);
		}
	}
	
	public void addParentesco(Membro p, TipoParentesco tp){
		Parentesco parentesco1 = new Parentesco();
		parentesco1.setParente(p);
		parentesco1.setTipo(tp);
		this.parentescos.add(parentesco1);
		Parentesco parentesco2 = new Parentesco();
		parentesco2.setParente(this);
		parentesco2.setTipo(tp.getEspelho());
		p.getParentescos().add(parentesco2);
	}
	
	public List<Parentesco> getParentescos() {
		return parentescos;
	}


	public ReligiaoEnum getReligiao() {
		return religiao;
	}

	public void setReligiao(ReligiaoEnum religiao) {
		this.religiao = religiao;
	}

	@Override
	public String toString() {
		String str = "Id: " + this.id + "Nome: " + this.getNome() + "\nSexo: " + this.sexo + "\nProfissao: " +this.profissao + "\nRenda Media Mensal: " + this.rendaMediaMensal + "\n\n";
		return str;
	}

	public String getNome() {
		return this.nome;
	}

	public char getSexo() {
		return this.sexo;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getProfissao() {
		// TODO Auto-generated method stub
		return this.profissao;
	}

	public double getRendaMediaMensal() {
		// TODO Auto-generated method stub
		return this.rendaMediaMensal;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
		
	}

	public void setRendaMediaMensal(double rendaMediaMensal) {
		this.rendaMediaMensal = rendaMediaMensal;
	}
	
}
