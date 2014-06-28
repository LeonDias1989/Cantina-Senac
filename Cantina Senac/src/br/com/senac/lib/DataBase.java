package br.com.senac.lib;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBase {
	
	private Connection connection = null;
	protected PreparedStatement preparedStatement = null;
	
	public void iniciarConexão(String comandoSQL) throws ClassNotFoundException, SQLException{
		
		connection = ConnecitonFactory.getConnection();
		preparedStatement = connection.prepareStatement(comandoSQL);
		
	}
	
	public void fecharConexao() throws SQLException{
		
		preparedStatement.close();
		connection.close();
	}

}
