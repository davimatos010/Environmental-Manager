package com.kraftheinzcompany.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kraftheinzcompany.data.OracleDBConnection;
import com.kraftheinzcompany.model.Ingredient;

public class IngredientDAO {
	private Connection connection;
	
	public void insert(Ingredient ingredient) {
		PreparedStatement stmt = null;
		int isSustainable;
		
		if(ingredient.isSustainable()) {
			isSustainable = 1;
		} else {
			isSustainable = 0;
		}
		
		try {
			connection = OracleDBConnection.getInstance().getConnection();
			String sql = "INSERT INTO T_KH_INGREDIENT (cd_ingredient, tp_sustainable, "
					+ "nm_ingredient, nm_origin, qt_amount) "
					+ "VALUES (SQ_INGREDIENT.NEXTVAL, ?, ?, ?, ?)"; 
			
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, isSustainable);
			stmt.setString(2, ingredient.getName());
			stmt.setString(3, ingredient.getOrigin());
			stmt.setInt(4, ingredient.getAmount());
			
			stmt.executeUpdate();
			
			System.out.println("Ingredient inserted into db");
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
