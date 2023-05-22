package com.kraftheinzcompany.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kraftheinzcompany.data.OracleDBConnection;
import com.kraftheinzcompany.model.WaterConsumption;
import com.kraftheinzcompany.utils.DateParser;

public class WaterConsumptionDAO {
	private Connection connection;
	
	public void insert(WaterConsumption consumption) {
		PreparedStatement stmt = null;
			 
		Date sqlPeriod = DateParser.localDateToSQl(consumption.getPeriod());
		
		try {
			connection = OracleDBConnection.getInstance().getConnection();
			String sql = "INSERT INTO T_KH_WATER_CONSUMPTION (cd_water_consumption, cd_factory, qt_water, dt_period, nm_source) "
					+ "VALUES (SQ_WATER_CONSUMPTION.nextval, ?, ?, ? ,?)"; 
			
			stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, consumption.getFactory().getId());
			stmt.setDouble(2, consumption.getQuantity());		 
			stmt.setDate(3, sqlPeriod);
			stmt.setString(4, consumption.getSource()); 
			
			stmt.executeUpdate();
			
			System.out.println("Water consumption inserted into db");
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
