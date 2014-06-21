package br.com.senac.dao;

import java.sql.ResultSet;
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
	public int remover(String matricula) {

		int rowsAffect = 0;

		try {
			iniciarConex�o("delete from cliente where matricula = ?");

			preparedStatement.setString(1, matricula);

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
	public String buscarPorMatricula(String matricula) {

		ResultSet resultado;
		String retorno = "";
		try {

			iniciarConex�o("select nome from cliente where matricula = ?");

			preparedStatement.setString(1, matricula);

			resultado = preparedStatement.executeQuery();

			while (resultado.next()) {
				retorno = resultado.getString("nome");
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retorno;
	}

	@Override
	public int creditarSaldo(double saldo, String matricula) {

		int rowsAffect = 0;

		try {
			iniciarConex�o("update cliente set saldo = ? + saldo where matricula = ?");

			preparedStatement.setDouble(1, saldo);
			preparedStatement.setString(2, matricula);

			rowsAffect = preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rowsAffect;
	}

	@Override
	public List<Cliente> getTodosClientes() {
		// TODO Auto-generated method stub
		return null;
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

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rowsAffect;
	}

	@Override
	public double getSaldoDataBase(String matricula) {

		ResultSet resultado;
		double retorno = 0;
		try {

			iniciarConex�o("select saldo from cliente where matricula = ?");

			preparedStatement.setString(1, matricula);

			resultado = preparedStatement.executeQuery();

			while (resultado.next()) {
				retorno = resultado.getDouble("saldo");
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retorno;
	}

}
