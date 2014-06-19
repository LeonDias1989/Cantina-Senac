package br.com.senac.dao.dao_interfaces;

import java.util.List;

import br.com.senac.model.Funcionario;


public interface FuncionarioDAO {
	
	int cadastrar(Funcionario funcionario);
	int remover(Funcionario funcionario);
	int atualizar(Funcionario funcionario);
	Funcionario buscarPorMatricula(String matricula);
	
	public List<Funcionario> getTodosClientes();
	int creditarSaldo(double saldo);

}
