package br.com.senac.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.senac.dao.dao_interfaces.ItemVendaDAO;
import br.com.senac.lib.DataBase;
import br.com.senac.model.ItemVenda;

public class ItemVendaDAODB extends DataBase implements ItemVendaDAO {

	@Override
	public ItemVenda cadastrarIdemVenda(int idVendaFK, int idprodutoFK) {

		ItemVenda itemVenda = null;
		try {
			iniciarConex�o("insert into itemDeVenda values (?, ?)");

			preparedStatement.setInt(1, idVendaFK);
			preparedStatement.setInt(2, idprodutoFK);

			preparedStatement.executeUpdate();

			itemVenda = new ItemVenda(idVendaFK, idprodutoFK);

			fecharConexao();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return itemVenda;
	}

	@Override
	public List<Integer> getProdutoDoCarrinho(int codigoVenda) {

		List<Integer> listaIdProdutos = new ArrayList<Integer>();
		ResultSet resultSet;

		try {
			iniciarConex�o("select id_produto_FK from itemDeVenda where idVenda_FK = ?");

			preparedStatement.setInt(1, codigoVenda);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				listaIdProdutos.add(resultSet.getInt("id_produto_FK"));
			}

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

		return listaIdProdutos;
	}

	@Override
	public void estornarItensDeVenda(int idVendaFK) {
		try {
			iniciarConex�o("delete from itemdevenda where idVenda_FK = ?");

			preparedStatement.setInt(1, idVendaFK);

			preparedStatement.executeUpdate();

			fecharConexao();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// public static void main(String[] args) {
	//
	// ItemVendaDAODB item = new ItemVendaDAODB();
	//
	// item.estornarItensDeVenda(9);
	//
	//
	// }

	// public static void main(String[] args) {
	//
	// ItemVendaDAODB itemVendaDAODB = new ItemVendaDAODB();
	//
	// List<Integer> listaDeInteiros = itemVendaDAODB.getProdutoDoCarrinho(9);
	//
	// System.out.println(listaDeInteiros.toString());
	//
	// List<Produto> listaProduto = new ArrayList<>();
	// ProdutoDAODB consultProduto = new ProdutoDAODB();
	//
	// for (Integer integer : listaDeInteiros) {
	//
	// listaProduto.add(consultProduto.getProduto(integer));
	//
	// }
	//
	// double precoTotal = 0;
	//
	// for (Produto produto : listaProduto) {
	// precoTotal += produto.getPreco();
	// }
	//
	// System.out.println(listaProduto.toString());
	// System.out.println(precoTotal);
	// }

}
