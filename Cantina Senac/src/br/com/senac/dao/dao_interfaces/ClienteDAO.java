package br.com.senac.dao.dao_interfaces;

import java.util.List;

import br.com.senac.model.Cliente;

public interface ClienteDAO {

	/** Retorna o número de linhas afetadas */
	int cadastrar(Cliente cliente);

	/** Retorna o número de linhas afetadas */
	int remover(Cliente cliente);

	/** Retorna o número de linhas afetadas */
	int atualizar(Cliente cliente);

	Cliente getCliente(String matricula);

	public List<Cliente> getTodosClientes();

	/** Retorna o número de linhas afetadas */
	int creditarSaldo(double saldo, String matricula);

	/** Retorna o número de linhas afetadas */
	int debitarSaldo(double saldo, String matricula);

}
