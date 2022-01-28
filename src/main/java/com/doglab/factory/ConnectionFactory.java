package com.doglab.factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {

	private static DataSource dataSource;
	
	private final static String URL = "jdbc:mysql://localhost:3306/loja";
	private final static String USER = "root";
	private final static String PASSWORD = "";
	
	public ConnectionFactory() {
		ComboPooledDataSource pool = new ComboPooledDataSource();
		pool.setJdbcUrl(URL);
		pool.setUser(USER);
		pool.setPassword(PASSWORD);
		
		pool.setMaxPoolSize(15);
		
		dataSource = pool;
	}
	
	public Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
