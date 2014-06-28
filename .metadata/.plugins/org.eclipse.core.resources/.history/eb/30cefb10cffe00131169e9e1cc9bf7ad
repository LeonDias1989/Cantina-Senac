package br.com.senac.lib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnecitonFactory {

	public final static String DATABASE = "Cantina Senac";
	public final static String USER = "postgres";
	public final static String PASSWORLD = "1234";

	public static Connection getConnection() throws ClassNotFoundException,
			SQLException {

		Class.forName("org.postgresql.Driver");
		String url = "jdbc:postgresql://localhost:5432/" + DATABASE;

		Connection connection = DriverManager.getConnection(url, USER,
				PASSWORLD);

		return connection;

	}

}
