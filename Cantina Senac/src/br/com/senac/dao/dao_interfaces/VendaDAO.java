package br.com.senac.dao.dao_interfaces;



import br.com.senac.model.Venda;

public interface VendaDAO {
	
	Venda cadastrarVenda(String matriculaCliente, String codigoFuncionario, java.sql.Date dataVenda);
	void estornarVenda(int codigoVenda);
}
