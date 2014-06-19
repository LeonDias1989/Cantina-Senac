package br.com.senac.testes;

import br.com.senac.dao.ClienteDAODB;
import br.com.senac.dao.FuncionarioDAODB;
import br.com.senac.model.Cliente;
import br.com.senac.model.Funcionario;

public class TesteDAODB {

	public static void main(String[] args) {

//		Cliente cliente0 = new Cliente("631120051", "Leon Dias Vieira",
//				"leondias1989@gmail.com", "1234ABCD");
//
//		ClienteDAODB daoDB = new ClienteDAODB();
//
//		System.out.println(daoDB.cadastrar(cliente0));
		
		Funcionario funcionario = new Funcionario("Avelino", "A310", "1234ABCD");
		
		FuncionarioDAODB funcionarioDAODB = new FuncionarioDAODB();
		
		System.out.println(funcionarioDAODB.cadastrar(funcionario));

	}

}
