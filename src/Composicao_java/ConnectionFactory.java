package Composicao_java;

import java.sql.*;

public class ConnectionFactory {
	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/funcionario",
					"root", "");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}