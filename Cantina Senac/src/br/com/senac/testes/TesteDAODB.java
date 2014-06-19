package br.com.senac.testes;

import br.com.senac.dao.ClienteDAODB;
import br.com.senac.model.Cliente;

public class TesteDAODB {

	public static void main(String[] args) {

		Cliente cliente0 = new Cliente("631120051", "Leon Dias Vieira",
				"leondias1989@gmail.com", "1234ABCD");

		ClienteDAODB daoDB = new ClienteDAODB();

		System.out.println(daoDB.cadastrar(cliente0));

	}

}
