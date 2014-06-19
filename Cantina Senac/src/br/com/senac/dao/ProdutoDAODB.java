package br.com.senac.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.senac.dao.dao_interfaces.ProdutoDAO;
import br.com.senac.model.Produto;

public class ProdutoDAODB extends DataBase implements ProdutoDAO {

	@Override
	public int cadastrar(Produto produto) {
		int rowsAffect = 0;

		try {
			iniciarConex�o("insert into produto (codigo, nome, categoria, preco) values (?, ?, ?, ?)");

			preparedStatement.setString(1, produto.getCodigo());
			preparedStatement.setString(2, produto.getNome());
			preparedStatement.setString(3, produto.getCategoria());
			preparedStatement.setDouble(4, produto.getPreco());

			rowsAffect = preparedStatement.executeUpdate();

			fecharConexao();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO AVISO: N�O FOI POSS�VEL EXECUTAR ESTE COMANDO
			e.printStackTrace();
		}

		return rowsAffect;
	}

	@Override
	public int remover(Produto produto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int atualizar(Produto produto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Produto buscarPorMatricula(String matricula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produto> getTodosClientes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int creditarSaldo(double saldo) {
		// TODO Auto-generated method stub
		return 0;
	}

}