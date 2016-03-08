package br.edu.ifpi.associapp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.ifpi.associapp.enuns.TipoDeComunidadeEnum;
import br.edu.ifpi.associapp.modelo.Comunidade;
import br.edu.ifpi.associapp.modelo.Endereco;
import br.edu.ifpi.associapp.modelo.Familia;

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
			JOptionPane.showMessageDialog(null, "Erro ao inserir Comunidade");
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
			f.setId(id);
			c.addFamilias(f);
			
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao inserir Familia");
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
			JOptionPane.showMessageDialog(null, "Erro ao inserir Endereco");
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return id;
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
	
	
	public List<Familia> listaFamilia() {
		List<Familia> lista = new ArrayList<>();
		conn = ConnectionFactory.getConnection();
		String sql = "SELECT * FROM familia";
		try {
			Statement stmt = conn.createStatement();
			ResultSet resultado = stmt.executeQuery(sql);
			while (resultado.next()) {
				Familia f = new Familia();
				Endereco end = new Endereco();
				String sql2 = "SELECT * FROM endereco WHERE id = "+
			resultado.getInt("id_endereco");
				Statement stmt2 = conn.createStatement();
				ResultSet resultado2 = stmt2.executeQuery(sql2);
				end.setRua(resultado2.getString("rua"));
				end.setNumero(resultado2.getInt("numero"));
				end.setCep(resultado2.getString("cep"));
				f.setId(resultado.getInt("id"));
				f.setEndereco(end);
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
				System.out.println("oo");
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
				f.setId(resultado.getInt("id"));
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
	
	

	@Override
	public void remover(Comunidade c) {
		// TODO Auto-generated method stub
		
	}

}
