package com.kraftheinzcompany.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kraftheinzcompany.data.OracleDBConnection;
import com.kraftheinzcompany.model.Address;

public class AddressDAO {
	private Connection connection;
	
	public void insert(Address address) {
		PreparedStatement stmt = null;
		
		try {
			connection = OracleDBConnection.getInstance().getConnection();
			
			String sql = "INSERT INTO T_KH_ADDRESS (zip_code, city, neighborhood, nm_street, nr_number, complement) "
					+ "VALUES (?, ?, ?, ?, ?, ?)";
			stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, address.getZipCode());
			stmt.setString(2, address.getCity());
			stmt.setString(3, address.getNeighborhood());
			stmt.setString(4, address.getStreet());
			stmt.setInt(5, address.getStreetNumber());
			stmt.setString(6, address.getComplement());
			
			stmt.executeUpdate();
			
			System.out.println("Address inserted into db");
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
