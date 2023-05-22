package com.kraftheinzcompany.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kraftheinzcompany.data.OracleDBConnection;
import com.kraftheinzcompany.model.Factory;

public class FactoryDAO {
	private Connection connection;
	
	public void insert (Factory factory) {
		PreparedStatement stmt = null;
		int isInRiskArea;
		
		if(factory.isInRiskArea()) {
			isInRiskArea = 1;
		} else {
			isInRiskArea = 0;
		}
		
		try {
			connection = OracleDBConnection.getInstance().getConnection(); 
			String sql = "INSERT INTO T_KH_FACTORY (cd_factory, zip_code, nr_document, st_risk_area) "
					+ "VALUES (SQ_FACTORY.nextval, ?, ?, ?)";
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, factory.getAddress().getZipCode());
			stmt.setString(2, factory.getDocument());
			stmt.setInt(3, isInRiskArea);
			
			stmt.executeUpdate();
			System.out.println("Factory inserted into db");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
