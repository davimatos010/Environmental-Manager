package com.kraftheinzcompany.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class OracleDBConnectionTest {

	public static void main(String[] args) {
		
		String DB_URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
		String DB_USER = "RM96873";
		String DB_PASSWORD = "100423";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			
			System.out.println("Conectado ao banco de dados!");
			
			connection.close();
			
		} catch (SQLException e) {
			System.err.println("Não foi possível conectar no banco de dados");
			System.out.println(e.getMessage());
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			System.err.println("O Driver JDBC não foi encontrado");
			e.printStackTrace();
		}
		
	}	

}
