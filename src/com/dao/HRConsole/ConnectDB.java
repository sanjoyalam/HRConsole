package com.dao.HRConsole;

import java.sql.*;

public class ConnectDB {

	private static ConnectDB instance = new ConnectDB();

	private ConnectDB() {

		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		}

	}

	public static ConnectDB getInstance() {

		return instance;
	}

	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/HR?" + "user=root&password=root");
		return connection;
	}
}
