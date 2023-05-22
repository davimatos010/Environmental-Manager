package com.kraftheinzcompany.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kraftheinzcompany.data.OracleDBConnection;
import com.kraftheinzcompany.model.Ingredient;
import com.kraftheinzcompany.utils.DateParser;
import com.kraftheinzcompany.utils.OracleSQLSequence;
import com.kraftheinzcompany.model.Batch;

public class BatchDAO {
	private Connection connection;
	
	public void insert(Batch batch) {
		PreparedStatement stmt = null;
		Date manufacturingDate = DateParser.localDateToSQl(batch.getFabricationDate());
		Date expirationDate = DateParser.localDateToSQl(batch.getExpirationDate());
		
		try {
			connection = OracleDBConnection.getInstance().getConnection();
			
			Integer batchCode = OracleSQLSequence.getNextVal("SQ_PROD_BATCH", connection);
			batch.setId(batchCode);
			
			String sql = "INSERT INTO T_KH_PROD_BATCH (cd_prod_batch, cd_factory, cd_packaging, nm_product, "
					+ "dt_manufacturing, dt_expiration) "
					+ "VALUES (?, ?, ?, ?, ?, ?)";
			
			stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, batch.getId());
			stmt.setInt(2, batch.getFactory().getId());
			stmt.setInt(3, batch.getPackaging().getId());
			stmt.setString(4, batch.getProduct());
			stmt.setDate(5, manufacturingDate);
			stmt.setDate(6, expirationDate);
			
			stmt.executeUpdate();
			
			for (Ingredient ingredient: batch.getIngredients()) {
				sql = "INSERT INTO T_KH_INGREDIENT_PRODUCT (cd_ingredient, cd_prod_batch) VALUES (?, ?)";
				stmt = connection.prepareStatement(sql);
				
				stmt.setInt(1, ingredient.getId());
				stmt.setInt(2, batch.getId());
				
				stmt.executeUpdate();
			}
			
			System.out.println("Batch added to db");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null) {
					stmt.close();					
				}
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
