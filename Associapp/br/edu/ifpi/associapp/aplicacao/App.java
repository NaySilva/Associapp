package br.edu.ifpi.associapp.aplicacao;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import br.edu.ifpi.associapp.dao.ComunidadeDAO;
import br.edu.ifpi.associapp.dao.ComunidadeJDBCDAO;
import br.edu.ifpi.associapp.dao.MembroDAO;
import br.edu.ifpi.associapp.dao.implemente.MembroDAOImplemente;
import br.edu.ifpi.associapp.enuns.TipoDeComunidadeEnum;
import br.edu.ifpi.associapp.modelo.Comunidade;
import br.edu.ifpi.associapp.modelo.Endereco;
import br.edu.ifpi.associapp.modelo.Familia;
import br.edu.ifpi.associapp.modelo.Membro;

public class App {
	

	public static void main(String[] args) {

		ComunidadeDAO dao = new ComunidadeJDBCDAO();
		
		String menu = "#### ASSOCIAPP ####\n\n";
		menu += "1 - Adicionar Comunidade\n"
				+ "2 - Acessar Comunidade\n"
				+ "3 - Lista de Comunidades\n"
				+ "4 - Remover Comnunidade\n"
				+ "0 - Sair\n";
		
		while(true){
			
			int op = Integer.parseInt(JOptionPane.showInputDialog(menu));
			switch (op){
			case 1:
				novaComunidade(dao);
				break;
			case 2:
				acessarComunidade(dao);
				break;
			case 3:
				listarComunidades(dao);
				break;
			case 0:
				JOptionPane.showMessageDialog(null, "Volte Sempre!");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção Invalida!");
				break;
			}
			if (op == 0)
				break;
			
			
		}
				
	}

	private static void listarComunidades(ComunidadeDAO dao) {
		String l = "LISTA\n";
		for (Comunidade c : dao.lista()) {
			l += c.toString();
		}
		JOptionPane.showMessageDialog(null, l);
		
	}

	private static void acessarComunidade(ComunidadeDAO dao) {
		Comunidade c = new Comunidade();
		int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id da comunidade: "));
		c = dao.obter(id);
		if (c==null){
			JOptionPane.showMessageDialog(null, "Não há nenhuma comunidade com esse id!");
			return;
		}
		String submenu = "Comunidade: " + c.getNome() + "\n\n";
		submenu += "1 - Adicionar Familia\n"
				+ "2 - Acessar Familia\n"
				+ "3 - Lista de Familias\n"
				+ "4 - Editar Dados da Comunidade\n"
				+ "0 - Voltar";
		
		while(true){
			int op2 = Integer.parseInt(JOptionPane.showInputDialog(submenu));
			switch (op2){
			case 1:
				novaFamilia(dao, c);
				break;
			case 2:
				acessarFamilia(dao);
				break;
			case 3: 
				listaDeFamilia(dao);
				break;
			case 4:
				addDadosDaComunidade(dao);
				break;
			case 0:
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção Invalida!");
				break;
			}
			if (op2 == 0)
				break;
			
			
		}
		
	}

	private static void listaDeFamilia(ComunidadeDAO dao) {
		String l = "LISTA DE FAMILIAS\n";
		for (Familia f : dao.listaFamilia()) {
			l += f.toString();
		}
		JOptionPane.showMessageDialog(null, l);
		
	}

	private static void addDadosDaComunidade(ComunidadeDAO dao) {
	}

	private static void acessarFamilia(ComunidadeDAO dao) {
		MembroDAO dao2 = new MembroDAOImplemente();
		Familia f = new Familia();
		int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id da familia: "));
		f = dao.obterFamilia(id);
		if (f==null){
			JOptionPane.showMessageDialog(null, "Não há nenhuma familia com esse id!");
			return;
		}
		String submenu2 = "Familia: " + id + "\n\n";
		submenu2 += "1 - Adicionar Membro\n"
				+ "2 - Acessar Membro\n"
				+ "3 - Lista de Membros\n"
				+ "4 - Editar Dados da Familia\n"
				+ "0 - Voltar\n";
		while(true){
			int op2 = Integer.parseInt(JOptionPane.showInputDialog(submenu2));
			switch (op2){
			case 1:
				novoMembro(dao2, f);
				break;
			case 2:
				acessarMembro(dao2);
				break;
			case 3: 
				listaDeMembros(dao2);
				break;
			case 4:
				DadosDaFamilia(dao);
				break;
			case 0:
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção Invalida!");
				break;
			}
			if (op2 == 0)
				break;
			
			
		}
		
	}

	private static void DadosDaFamilia(ComunidadeDAO dao3) {
		// TODO Auto-generated method stub
		
	}

	private static void acessarMembro(MembroDAO dao2) {
		Membro p = new Membro();
		int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id da Pessoa: "));
		p = dao2.retornarMembroPorId(id);
		if (p==null){
			JOptionPane.showMessageDialog(null, "Não há nenhum membro com esse id!");
			return;
		}
		String dados = "Membro: " + p.getNome() + "\n\n";
		dados += "1 - Adicionar Membro\n"
				+ "2 - Vizualizar Membro\n"
				+ "3 - Adicionar Dados da Familia\n"
				+ "0 - Voltar\n";
		
	}

	private static void listaDeMembros(MembroDAO dao2) {
		String l = "LISTA DE MEMBROS\n";
		for (Membro p : dao2.listaMembros()) {
			l += p.toString();
		}
		JOptionPane.showMessageDialog(null, l);
		
	}

	private static void novoMembro(MembroDAO dao2, Familia f) {
		Membro p = new Membro();
		UIManager.put("OptionPane.okButtonText", "Proximo");
		String nome = JOptionPane.showInputDialog("Nome: ");
		char sexo = JOptionPane.showInputDialog("Sexo(f/m): ").charAt(0);
		String profissao = JOptionPane.showInputDialog("Profissao: ");
		UIManager.put("OptionPane.okButtonText", "Fim");
		double renda = Double.parseDouble(JOptionPane.showInputDialog("Renda Media Mensal: "));
		p.setNome(nome);
		p.setSexo(sexo);
		p.setProfissao(profissao);
		p.setRendaMediaMensal(renda);
		p = dao2.inserirMembro(p, f);
		UIManager.put("OptionPane.okButtonText", "Ok");
		JOptionPane.showMessageDialog(null, "Inseriu com sucesso. Id gerado: "+p.getId()+"!");
	}

	private static void novaFamilia(ComunidadeDAO dao, Comunidade c) {
		Familia f = new Familia();
		UIManager.put("OptionPane.okButtonText", "Proximo");
		String rua = JOptionPane.showInputDialog("Informacoes da casa\nRua: ");
		int numero = Integer.parseInt(JOptionPane.showInputDialog("Informacoes da casa\nNumero: "));
		UIManager.put("OptionPane.okButtonText", "Fim");
		String cep = JOptionPane.showInputDialog("Informacoes da casa\nCep: ");
		Endereco end = new Endereco(rua, numero, cep);
		int id = dao.inserirEndereco(end, f);
		f = dao.inserirFamilia(c, f, id);
		UIManager.put("OptionPane.okButtonText", "Ok");
		JOptionPane.showMessageDialog(null, "Inseriu com sucesso. Id gerado: "+f.getCodigo()+"!");
	}

	private static void novaComunidade(ComunidadeDAO dao) {
		Comunidade c = new Comunidade();
		UIManager.put("OptionPane.okButtonText", "Proximo");
		String nome = JOptionPane.showInputDialog("Nome: ");
		String opcoes = "1 - BAIRRO\n"
				+ "2 - POVOADO";
		int tipo = Integer.parseInt(JOptionPane.showInputDialog(opcoes));
		UIManager.put("OptionPane.okButtonText", "Fim");
		int idade = Integer.parseInt(JOptionPane.showInputDialog("Idade Minima Do Lider: "));
		c.setNome(nome);
		c.setTipo(TipoDeComunidadeEnum.fromInteger(tipo));
		c.setIdadeMinimaLider(idade);;
		c = dao.inserir(c);
		UIManager.put("OptionPane.okButtonText", "Ok");
		JOptionPane.showMessageDialog(null, "Inseriu com sucesso. Id gerado: "+c.getCodigo()+"!");
		
	}

}
