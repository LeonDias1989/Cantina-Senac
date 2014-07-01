package br.com.senac.relatorios;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.senac.lib.DataBase;

public class RelatorioDAODB extends DataBase {

	public String getVendasPorCliente(String matricula) {

		String aux = "";
		ResultSet resultSet;
		try {
			iniciarConex�o("select (select nome from cliente where matricula = clienteFK), datavenda,(select nomeProduto from produto  where codigo = itemdevenda.id_produto_fk) from venda inner join itemdevenda on  venda.id_venda = itemDevenda.idvenda_FK and venda.clienteFK = ?");

			preparedStatement.setString(1, matricula);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				aux += resultSet.getString("nome");
				aux += "|	";
				aux += resultSet.getString("dataVenda");
				aux += "|	";
				aux += resultSet.getString("nomeproduto");
				aux += "\n";

			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return aux;
	}

	public String getVendasPorFuncionario(String codigo) {

		String aux = "";
		ResultSet resultSet;
		try {
			iniciarConex�o("select  (select nome from funcionario where codigo = funcionarioFK), datavenda,(select nomeProduto from produto  where codigo = itemdevenda.id_produto_fk) from venda inner join itemdevenda on  venda.id_venda = itemDevenda.idvenda_FK and funcionarioFK = '2'");

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				aux += resultSet.getString("nome");
				aux += "|	";
				aux += resultSet.getString("dataVenda");
				aux += "|	";
				aux += resultSet.getString("nomeproduto");
				aux += "\n";

			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return aux;
	}

	@SuppressWarnings("unused")
	private String getVendasPorData(String dataVenda) {

		ResultSet resultSet;
		String aux = "";

		try {
			iniciarConex�o("select (select nome from cliente where matricula = clienteFK), (select nome from funcionario where codigo = funcionarioFK), datavenda,(select nomeproduto from produto  where codigo = itemdevenda.id_produto_fk) from venda inner join itemdevenda on  venda.id_venda = itemDevenda.idvenda_FK and venda.datavenda  = ? ");

			preparedStatement.setString(1, dataVenda);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				aux += resultSet.getString("nomecliente");
				aux += "|";
				aux += resultSet.getString("nome");
				aux += "|";
				aux += resultSet.getString("dataVenda");
				aux += "|";
				aux += resultSet.getString("nomeproduto");
				aux += "\n";
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return aux;
	}

}
