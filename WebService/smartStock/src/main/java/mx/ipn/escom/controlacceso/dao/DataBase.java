package mx.ipn.escom.controlacceso.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBase {
	
	public DataBase() {
		super();
	}
	
	public Connection getConnection() throws Exception {
		try {
			String connectionURL = "jdbc:mysql://localhost:3306/mydb";
			Connection connection = null;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(connectionURL, "root", "");
			return connection;
		} catch (Exception e) {
			throw e;
		}

	}

}
