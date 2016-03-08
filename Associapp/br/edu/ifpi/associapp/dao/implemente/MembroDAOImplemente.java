package br.edu.ifpi.associapp.dao.implemente;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.ifpi.associapp.dao.ConnectionFactory;
import br.edu.ifpi.associapp.dao.MembroDAO;
import br.edu.ifpi.associapp.enuns.TipoDeComunidadeEnum;
import br.edu.ifpi.associapp.modelo.Comunidade;
import br.edu.ifpi.associapp.modelo.Familia;
import br.edu.ifpi.associapp.modelo.Membro;

public class MembroDAOImplemente implements MembroDAO {

	private Connection conn = ConnectionFactory.getConnection();
	
	@Override
	public Membro inserirMembro(Membro m, Familia f) {
		conn = ConnectionFactory.getConnection();
		
		try {
			Statement s = conn.createStatement();
			String sql = "INSERT INTO membro(nome, sexo, profissao, rendaMediaMensal, id_familia) values('"+ m.getNome()+"', '"
					+m.getSexo()+"', '" + m.getProfissao() + "', " + m.getRendaMediaMensal() + ", " + f.getCodigo()+ ")";
			s.executeUpdate(sql);
			sql = "SELECT id FROM membro ORDER BY id DESC limit 1";
			ResultSet rs = s.executeQuery(sql);
			int id = rs.getInt("id");
			m.setId(id);
			f.addMembro(m);
			
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao inserir Membro da Familia");
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return m;
	}
			

	@Override
	public Membro retornarMembroPorId(int id) {
		Membro m = null;
		try {
			String sql = "SELECT * FROM membro WHERE id = " + id;
			
			Statement stmt = conn.createStatement();
			ResultSet resultado = stmt.executeQuery(sql);
			while (resultado.next()) {
				m = new Membro();
				m.setId(resultado.getInt("id"));
				m.setNome(resultado.getString("nome"));
				m.setSexo(resultado.getString("sexo").charAt(0));
				m.setProfissao(resultado.getString("profissao"));
				m.setRendaMediaMensal(resultado.getDouble("rendaMediaMensal"));
			}
			return m;
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
	public void removerMembro(int id) {
		try {
			Statement s = conn.createStatement();
			String sql = "DELETE from membro where id = " +id;
			
			s.executeUpdate(sql);
		
			JOptionPane.showMessageDialog(null, "Membro deletado com sucesso!!");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao deletar Membro!");
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public List<Membro> listaMembros() {
		List<Membro> listaMembros = new ArrayList<>();
		String sql = "SELECT * FROM membro";
		try {
			Statement stmt = conn.createStatement();
			ResultSet resultado = stmt.executeQuery(sql);
			while (resultado.next()) {
				Membro m = new Membro();
				m = new Membro();
				m.setId(resultado.getInt("id"));
				m.setNome(resultado.getString("nome"));
				m.setSexo(resultado.getString("sexo").charAt(0));
				m.setProfissao(resultado.getString("profissao"));
				m.setRendaMediaMensal(resultado.getDouble("rendaMediaMensal"));
				listaMembros.add(m);
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
		
		return listaMembros;
	}

}