package br.com.senac.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.senac.dao.dao_interfaces.ProdutoDAO;
import br.com.senac.lib.DataBase;
import br.com.senac.model.Produto;

public class ProdutoDAODB extends DataBase implements ProdutoDAO {

	@Override
	public int cadastrar(Produto produto) {
		int rowsAffect = 0;

		try {
			iniciarConex�o("insert into produto (nome, tipo, preco) values (?, ?, ?)");

			preparedStatement.setString(1, produto.getNome());
			preparedStatement.setString(2, produto.getCategoria());
			preparedStatement.setDouble(3, produto.getPreco());

			rowsAffect = preparedStatement.executeUpdate();

			fecharConexao();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO AVISO: N�O FOI POSS�VEL EXECUTAR ESTE COMANDO
			e.printStackTrace();
		}

		return rowsAffect;
	}

	@Override
	public int remover(int codigo) {

		int rowsAffect = 0;

		try {
			iniciarConex�o("delete from produto where codigo = ?");

			preparedStatement.setInt(1, codigo);

			rowsAffect = preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return rowsAffect;
	}

	@Override
	public int atualizar(Produto produto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Produto getProduto(int codigo) {
		ResultSet resultado;
		Produto produto = new Produto();
		try {

			iniciarConex�o("select * from produto where codigo = ?");

			preparedStatement.setDouble(1, codigo);

			resultado = preparedStatement.executeQuery();

			while (resultado.next()) {
				produto.setCategoria(resultado.getString("codigo"));
				produto.setNome(resultado.getString("nome"));
				produto.setPreco(resultado.getDouble("preco"));
				produto.setCategoria(resultado.getString("tipo"));
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return produto;
	}

	@Override
	public List<Produto> getAllProdutos() {

		List<Produto> produtos = new ArrayList<Produto>();
		ResultSet resultSet;

		try {
			iniciarConex�o("select * from Produto");
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				produtos.add(new Produto(resultSet.getInt("codigo"), resultSet
						.getString("nome"), resultSet.getString("tipo"),
						resultSet.getDouble("preco")));

			}

			fecharConexao();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return produtos;
	}

	public List<Produto> getAllProdutosSemCodigo() {

		List<Produto> produtos = new ArrayList<Produto>();
		ResultSet resultSet;

		try {
			iniciarConex�o("select * from Produto");
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				produtos.add(new Produto(resultSet.getString("nome"), resultSet
						.getString("tipo"), resultSet.getDouble("preco")));

			}

			fecharConexao();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return produtos;
	}

}
