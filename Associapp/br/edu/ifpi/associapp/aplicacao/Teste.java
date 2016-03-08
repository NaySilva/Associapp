package br.edu.ifpi.associapp.aplicacao;

import br.edu.ifpi.associapp.modelo.Comunidade;
import br.edu.ifpi.associapp.modelo.Data;
import br.edu.ifpi.associapp.modelo.Pessoa;
import br.edu.ifpi.associapp.dao.ComunidadeDAO;
import br.edu.ifpi.associapp.dao.ComunidadeJDBCDAO;
import br.edu.ifpi.associapp.enuns.*;

public class Teste {

	public static void main(String[] args) {
			
			ComunidadeDAO dao = new ComunidadeJDBCDAO();
			
			Comunidade c = new Comunidade();
//			c.setNome("SANTA MARIA");
//			c.setTipo(TipoDeComunidadeEnum.POVOADO);
//			c.setIdadeMinimaLider(18);;
//			
//			c = dao.inserir(c);
			
			c = dao.obter(2);
			System.out.println("Inseriu com sucesso. Id gerado:"+c.getNome());
			
		}
	

}
