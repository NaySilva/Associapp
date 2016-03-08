package br.edu.ifpi.associapp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpi.associapp.enuns.TipoDeComunidadeEnum;
import br.edu.ifpi.associapp.modelo.Comunidade;
import br.edu.ifpi.associapp.modelo.Endereco;
import br.edu.ifpi.associapp.modelo.Familia;
import br.edu.ifpi.associapp.modelo.Pessoa;

public class ComunidadeJDBCDAO implements ComunidadeDAO {

	private Connection conn;

	@Override
	public Comunidade inserir(Comunidade c) {
		conn = ConnectionFactory.getConnection();
		
		try {
			Statement s = conn.createStatement();
			String sql = "INSERT INTO comunidade(nome, idadeMinimaLider, tipo) values('"+c.getNome()+"', "
					+c.getIdadeMinimaLider()+", '"+c.getTipo()+"')";
			s.executeUpdate(sql);
			
			sql = "SELECT id FROM comunidade ORDER BY id DESC limit 1";
			ResultSet rs = s.executeQuery(sql);
			int id = rs.getInt("id");
			c.setCodigo(id);
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro ao inserir Comunidade");
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return c;
	}
	
	public Familia inserirFamilia(Comunidade c, Familia f, int end) {
		conn = ConnectionFactory.getConnection();
		
		try {
			Statement s = conn.createStatement();
			String sql = "INSERT INTO familia(id_endereco, id_comunidade) values("+end+", "
					+c.getCodigo()+")";
			s.executeUpdate(sql);
			sql = "SELECT id FROM familia ORDER BY id DESC limit 1";
			ResultSet rs = s.executeQuery(sql);
			int id = rs.getInt("id");
			f.setCodigo(id);
			System.out.println(f.getCodigo());
			c.addFamilias(f);
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro ao inserir Familia");
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return f;
	}
	public int inserirEndereco(Endereco end, Familia f) {
		conn = ConnectionFactory.getConnection();
		int id = 0;
		
		try {
			Statement s = conn.createStatement();
			String sql = "INSERT INTO endereco(rua, numero, cep) values('"+end.getRua()+"', "
					+end.getNumero()+", '"+ end.getCep() + "')";
			s.executeUpdate(sql);
			sql = "SELECT id FROM endereco ORDER BY id DESC limit 1";
			ResultSet rs = s.executeQuery(sql);
			id = rs.getInt("id");
			f.setEndereco(end);
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro ao inserir Endereco");
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return id;
	}
	
	public Pessoa inserirPessoa(Pessoa p, Familia f) {
		conn = ConnectionFactory.getConnection();
		
		try {
			Statement s = conn.createStatement();
			String sql = "INSERT INTO pessoa(nome, sexo, id_familia) values('"+ p.getNome()+"', '"
					+p.getSexo()+"', "+ f.getCodigo()+ ")";
			s.executeUpdate(sql);
			sql = "SELECT id FROM pessoa ORDER BY id DESC limit 1";
			ResultSet rs = s.executeQuery(sql);
			int id = rs.getInt("id");
			p.setCodigo(id);
			f.addMembro(p);
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro ao inserir Membro da Familia");
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return p;
	}

	@Override
	public List<Comunidade> lista() {
		List<Comunidade> lista = new ArrayList<>();
		conn = ConnectionFactory.getConnection();
		String sql = "SELECT * FROM comunidade";
		try {
			Statement stmt = conn.createStatement();
			ResultSet resultado = stmt.executeQuery(sql);
			while (resultado.next()) {
				Comunidade c = new Comunidade();
				c.setCodigo(resultado.getInt("id"));
				c.setNome(resultado.getString("nome"));
				c.setIdadeMinimaLider(resultado.getInt("idadeMinimaLider"));
				c.setTipo(TipoDeComunidadeEnum.valueOf(resultado.getString("tipo")));
				lista.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return lista;
	}
	
	public List<Pessoa> listaDePessoas() {
		List<Pessoa> lista = new ArrayList<>();
		conn = ConnectionFactory.getConnection();
		String sql = "SELECT * FROM pessoa";
		try {
			Statement stmt = conn.createStatement();
			ResultSet resultado = stmt.executeQuery(sql);
			while (resultado.next()) {
				Pessoa p = new Pessoa();
				p.setCodigo(resultado.getInt("id"));
				p.setNome(resultado.getString("nome"));
				p.setSexo(resultado.getString("sexo").charAt(0));
				lista.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return lista;
	}
	
	public List<Familia> listaFamilia() {
		List<Familia> lista = new ArrayList<>();
		conn = ConnectionFactory.getConnection();
		String sql = "SELECT * FROM familia";
		try {
			Statement stmt = conn.createStatement();
			ResultSet resultado = stmt.executeQuery(sql);
			while (resultado.next()) {
				String sql2 = "SELECT * FROM endereco WHERE id = "+
			resultado.getInt("id_endereco")+"";
				ResultSet resultado2 = stmt.executeQuery(sql2);
				Familia f = new Familia();
				Endereco end = new Endereco();
				end.setRua(resultado2.getString("rua"));
				end.setNumero(resultado2.getInt("numero"));
				end.setCep(resultado2.getString("cep"));
				f.setCodigo(resultado.getInt("id"));
				f.setEndereco(end);
				f.setIdComunidade(resultado.getInt("id_comunidade"));
				lista.add(f);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return lista;
	}
	
	@Override
	public Comunidade obter(int id) {
		conn = ConnectionFactory.getConnection();
		String sql = "SELECT * FROM comunidade WHERE id = " + id;
		Comunidade c = null;
		try {
			Statement stmt = conn.createStatement();
			ResultSet resultado = stmt.executeQuery(sql);
			while (resultado.next()) {
				c = new Comunidade();
				c.setCodigo(resultado.getInt("id"));
				c.setNome(resultado.getString("nome"));
				c.setIdadeMinimaLider(resultado.getInt("idadeMinimaLider"));
				c.setTipo(TipoDeComunidadeEnum.valueOf(resultado.getString("tipo")));
			}
			return c;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public Familia obterFamilia(int id) {
		conn = ConnectionFactory.getConnection();
		String sql = "SELECT * FROM familia WHERE id = " + id;
		Familia f = null;
		try {
			Statement stmt = conn.createStatement();
			ResultSet resultado = stmt.executeQuery(sql);
			while (resultado.next()) {
				f = new Familia();
				f.setCodigo(resultado.getInt("id"));
			}
			return f;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public Pessoa obterPessoa(int id) {
		conn = ConnectionFactory.getConnection();
		String sql = "SELECT * FROM familia WHERE id = " + id;
		Pessoa p = null;
		try {
			Statement stmt = conn.createStatement();
			ResultSet resultado = stmt.executeQuery(sql);
			while (resultado.next()) {
				p = new Pessoa();
				p.setCodigo(resultado.getInt("id"));
			}
			return p;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public void remover(Comunidade c) {
		// TODO Auto-generated method stub
		
	}

}
