package br.com.senac.dao;

import java.sql.SQLException;
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
			// TODO AVISO: N�O FOI POSS�VEL EXECUTAR ESTE COMANDO
			e.printStackTrace();
		}

		return rowsAffect;
	}

	@Override
	public int remover(Cliente cliente) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int atualizar(Cliente cliente) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Cliente buscarPorMatricula(String matricula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int creditarSaldo(double saldo) {

		return 0;
	}

	@Override
	public List<Cliente> getTodosClientes() {
		// TODO Auto-generated method stub
		return null;
	}

}
