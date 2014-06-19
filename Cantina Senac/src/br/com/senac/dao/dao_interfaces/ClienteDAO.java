package br.com.senac.dao.dao_interfaces;

import java.util.List;

import br.com.senac.model.Cliente;

public interface ClienteDAO {
	
	int cadastrar(Cliente cliente);

	int remover(Cliente cliente);

	int atualizar(Cliente cliente);

	Cliente buscarPorMatricula(String matricula);

	public List<Cliente> getTodosClientes();

	int creditarSaldo(double saldo);

}
