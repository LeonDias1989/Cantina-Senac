package br.com.senac.dao;

import java.sql.SQLException;

import br.com.senac.dao.dao_interfaces.VendaDAO;

public class VendaDAODB extends DataBase implements VendaDAO {

	@Override
	public int venderProduto(int codigoProduto, String codigoFuncionario,
			String matriculaCliente) {

		int rowsAffect = 0;

		try {
			iniciarConex�o("insert into venda (produtoFK, funcionarioFK, clienteFK) values (?, ?, ?)");

			//Debitar valor do cliente selecionando o pre�o do produto
			
			preparedStatement.setInt(1, codigoProduto);
			preparedStatement.setString(2, codigoFuncionario);
			preparedStatement.setString(3, matriculaCliente);

			rowsAffect = preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		return rowsAffect;
	}

}
