package br.com.senac.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.senac.dao.dao_interfaces.ClienteDAO;
import br.com.senac.model.Cliente;

public class ClienteDAODB extends DataBase implements ClienteDAO {

	@Override
	public int cadastrar(Cliente cliente) {

		int rowsAffect = 0;

		try {
			iniciarConex�o("insert into cliente (matricula, nome, email, senha) values (?, ?, ?, ?)");

			preparedStatement.setString(1, cliente.getMatricula());
			preparedStatement.setString(2, cliente.getNome());
			preparedStatement.setString(3, cliente.getEmail());
			preparedStatement.setString(4, cliente.getSenha());

			rowsAffect = preparedStatement.executeUpdate();

			fecharConexao();

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

		return rowsAffect;
	}

	@Override
	public int remover(Cliente cliente) {

		int rowsAffect = 0;

		try {
			iniciarConex�o("delete from cliente where matricula = ?");

			preparedStatement.setString(1, cliente.getMatricula());

			rowsAffect = preparedStatement.executeUpdate();

			fecharConexao();

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

		return rowsAffect;
	}

	@Override
	public int atualizar(Cliente cliente) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Cliente getCliente(String matricula) {

		ResultSet resultSet;
		Cliente cliente = new Cliente();
		try {

			iniciarConex�o("select * from cliente where matricula = ?");

			preparedStatement.setString(1, matricula);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				cliente.setMatricula(resultSet.getString("matricula"));
				cliente.setNome(resultSet.getString("nome"));
				cliente.setEmail(resultSet.getString("email"));
				cliente.setSenha(resultSet.getString("senha"));
				cliente.setSaldo(resultSet.getDouble("saldo"));
			}

			fecharConexao();

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		return cliente;
	}

	@Override
	public int creditarSaldo(double saldo, String matricula) {

		int rowsAffect = 0;

		try {
			iniciarConex�o("update cliente set saldo = ? + saldo where matricula = ?");

			preparedStatement.setDouble(1, saldo);
			preparedStatement.setString(2, matricula);

			rowsAffect = preparedStatement.executeUpdate();

			fecharConexao();

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

		return rowsAffect;
	}

	@Override
	public List<Cliente> getTodosClientes() {
		ResultSet resultSet;
		List<Cliente> clientes = new ArrayList<Cliente>();
		try {

			iniciarConex�o("select * from cliente");

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				clientes.add(new Cliente(resultSet.getString("matricula"),
						resultSet.getString("nome"), resultSet
								.getString("email"), resultSet
								.getString("senha")));

			}

			fecharConexao();

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		return clientes;
	}

	@Override
	public int debitarSaldo(double saldo, String matricula) {
		int rowsAffect = 0;

		double saldoADebitar = saldo - (saldo * 2);

		try {
			iniciarConex�o("update cliente set saldo = ? + saldo where matricula = ?");

			preparedStatement.setDouble(1, saldoADebitar);
			preparedStatement.setString(2, matricula);

			rowsAffect = preparedStatement.executeUpdate();

			fecharConexao();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rowsAffect;
	}

}
