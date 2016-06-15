package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem {
	public static void main(String[] args) throws SQLException {
		//Campos da tabela
		String nome = "Notebook";
		String descricao = "Notebook i5";
		//SQL
		String sql = "insert into Produto (nome, descricao) values ('" + nome + "', '" + descricao + "')"; 
		
		// Faz conexão com o banco através de um driver específico
		Connection connection = Database.getConnection();
		
		
		Statement statement = connection.createStatement();
		boolean resultado = statement.execute(sql, statement.RETURN_GENERATED_KEYS);		
		ResultSet resultSet = statement.getGeneratedKeys();
		
		while (resultSet.next()){
			String id = resultSet.getString("id");			
			
			System.out.println(id + " gerado");
		}
		
		resultSet.close();
		statement.close();
		
		connection.close();
	}
}
