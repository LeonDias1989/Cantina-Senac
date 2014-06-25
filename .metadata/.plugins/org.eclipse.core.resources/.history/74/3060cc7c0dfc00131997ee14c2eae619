package br.com.senac.dao.dao_interfaces;

import java.util.List;

import br.com.senac.model.Cliente;

public interface ClienteDAO {
	
	int cadastrar(Cliente cliente);

	int remover(String matricula);

	int atualizar(Cliente cliente);

	String buscarPorMatricula(String matricula);

	public List<Cliente> getTodosClientes();
	
	public double getSaldoDataBase(String matricula);

	int creditarSaldo(double saldo, String matricula);
	
	int debitarSaldo(double saldo, String matricula);

}
