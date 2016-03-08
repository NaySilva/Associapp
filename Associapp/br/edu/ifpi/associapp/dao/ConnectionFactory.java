package br.edu.ifpi.associapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static Connection getConnection(){
		try {
			return DriverManager.getConnection("jdbc:sqlite:associapp.db");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Não foi possivel obter uma conexao!");
		}
	}
	
}
