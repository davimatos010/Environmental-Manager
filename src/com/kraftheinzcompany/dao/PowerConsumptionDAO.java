package com.kraftheinzcompany.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kraftheinzcompany.data.OracleDBConnection;
import com.kraftheinzcompany.model.PowerConsumption;
import com.kraftheinzcompany.utils.DateParser;

public class PowerConsumptionDAO {
	private Connection connection;
	
	public void insert(PowerConsumption consumption) {
		PreparedStatement stmt = null;
		
		Date sqlPeriod = DateParser.localDateToSQl(consumption.getPeriod());
		
		try {
			connection = OracleDBConnection.getInstance().getConnection();
			String sql = "INSERT INTO T_KH_POWER_CONSUMPTION (cd_power_consumption, cd_factory, qt_power, dt_period, nm_source, tp_power) "
					+ "VALUES (SQ_power_consumption.nextval, ?, ?, ?, ?, ?)"; 
			
			stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, consumption.getFactory().getId());
			stmt.setDouble(2, consumption.getQuantity());
			stmt.setDate(3, sqlPeriod);
			stmt.setString(4, consumption.getSource());
			stmt.setString(5, consumption.getType());
			
			stmt.executeUpdate();
			
			System.out.println("Power consumption inserted into db");
			
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
