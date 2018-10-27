package com.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.utils.ApplicationProperties;

public class DAO {
	
	private Connection con;
	private PreparedStatement pst;
	
	public DAO() throws ClassNotFoundException, SQLException {
		ApplicationProperties applicationProperties = ApplicationProperties.getInstance();
		Class.forName(applicationProperties.getProperty("driver-class-name"));
		//System.out.println(applicationProperties.getProperty("driver-class-name"));
		this.con = DriverManager.getConnection(applicationProperties.getProperty("url"), applicationProperties.getProperty("username"), applicationProperties.getProperty("password"));
	}
	
	protected ResultSet executeQuery(String query, Object... values) throws SQLException {
		this.pst = this.con.prepareStatement(query);
		for(int i = 0; i < values.length; i++) {
			this.pst.setObject(i + 1, values[i]);
		}
		return this.pst.executeQuery();
	}
	
	protected int executeUpdate(String query, Object... values) throws SQLException {
		this.pst = this.con.prepareStatement(query);
		for(int i = 0; i < values.length; i++) {
			this.pst.setObject(i+1, values[i]);
		}
		return this.pst.executeUpdate();
}

}
