package com.kraftheinzcompany.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kraftheinzcompany.data.OracleDBConnection;
import com.kraftheinzcompany.model.Packaging;

public class PackagingDAO {
	private Connection connection;
	
	public void insert(Packaging packaging) {
		PreparedStatement stmt = null;
		int isRecyclable;
		
		if(packaging.isRecyclable()) {
			isRecyclable = 1;
		} else {
			isRecyclable = 0;
		}
		
		try {
			connection = OracleDBConnection.getInstance().getConnection();
			String sql = "INSERT INTO T_KH_PACKAGING (cd_packaging, nm_material, tp_reciclable) "
					+ "VALUES (SQ_PACKAGING.NEXTVAL, ?, ?)"; 
			
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, packaging.getMaterial());
			stmt.setInt(2, isRecyclable);

			stmt.executeUpdate();
			System.out.println("Packaging added to db");
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
