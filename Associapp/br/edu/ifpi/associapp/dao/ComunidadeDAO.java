package br.edu.ifpi.associapp.dao;

import java.util.List;

import br.edu.ifpi.associapp.modelo.Comunidade;
import br.edu.ifpi.associapp.modelo.Endereco;
import br.edu.ifpi.associapp.modelo.Familia;
import br.edu.ifpi.associapp.modelo.Pessoa;

public interface ComunidadeDAO {
	
	public Comunidade inserir(Comunidade c);
	public Familia inserirFamilia(Comunidade c, Familia f, int end);
	public int inserirEndereco(Endereco end, Familia f);
	public Pessoa inserirPessoa(Pessoa p, Familia f);
	public List<Comunidade> lista();
	public List<Familia> listaFamilia();
	public List<Pessoa> listaDePessoas();
	public Comunidade obter(int id);
	public Familia obterFamilia(int id);
	public Pessoa obterPessoa(int id);
	public void remover(Comunidade c);

}
