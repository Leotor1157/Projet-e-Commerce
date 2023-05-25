package fr.doranco.jsf.model.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public final class DataBaseConnection {

	private DataBaseConnection() {
	}
	
	public static Connection getConnection() throws Exception {
		
		ResourceBundle rs = ResourceBundle.getBundle("dbfile");
		String user = rs.getString("user");
		String password = rs.getString("password");
		String url = rs.getString("url");
		String driver = rs.getString("driver");
		Class.forName(driver);
		
		Connection connection = DriverManager.getConnection(url, user, password);
		return connection;
	}
}
