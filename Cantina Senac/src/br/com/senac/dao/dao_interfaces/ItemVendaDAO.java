package br.com.senac.dao.dao_interfaces;

import java.util.List;

import br.com.senac.model.ItemVenda;

public interface ItemVendaDAO {

	ItemVenda cadastrarIdemVenda(int idVendaFK, int idprodutoFK);

	List<Integer> getIdProdutoDoCarrinho(int codigoVenda);

	void estornarItensDeVenda(int idVendaFK);

}
