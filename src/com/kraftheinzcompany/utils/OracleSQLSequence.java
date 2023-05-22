package com.kraftheinzcompany.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class OracleSQLSequence {
	public static Integer getNextVal(String sequenceName, Connection connection) throws SQLException {
		Integer nextVal = null;
		
		String sql = "SELECT " + sequenceName + ".nextval FROM DUAL";
		
		System.out.println(sql);
		
		PreparedStatement stmt = connection.prepareStatement(sql);
		
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
			nextVal = rs.getInt(1);
		}
		
		return nextVal;
	}
	
	public static Integer getCurrVal(String sequenceName, Connection connection) throws SQLException {
		OracleSQLSequence.getNextVal(sequenceName, connection);
		
		Integer currVal = null;
		
		String sql = "SELECT " + sequenceName + ".currval FROM DUAL";
		
		PreparedStatement stmt = connection.prepareStatement(sql);
		
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
			currVal = rs.getInt(1);
		}
		
		return currVal;
	}
	
	public static Integer getMostRecentVal(String columnName, String tableName, Connection connection) throws SQLException {
		Integer recentVal = null;
		
		String sql = "SELECT " + columnName + " FROM (SELECT " + columnName + " FROM " + tableName + 
	             " ORDER BY ROWNUM DESC) WHERE ROWNUM = 1";
		
		PreparedStatement stmt = connection.prepareStatement(sql);
		
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
			recentVal = rs.getInt(columnName);

		}
		
		return recentVal;
	}
}
