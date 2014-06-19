package br.com.senac.model;

import javax.swing.JTextField;

public class Funcionario {

	private String nome;
	private String codigoFuncionario;
	private String senha;

	public Funcionario(String nome, String codigoFuncionario, String senha) {
		super();
		this.nome = nome;
		this.codigoFuncionario = codigoFuncionario;
		this.senha = senha;
	}

	public Funcionario(JTextField textFieldNome,
			JTextField textFieldCodigoFuncionario, String senha) {
		this.nome = textFieldNome.getText();
		this.codigoFuncionario = textFieldCodigoFuncionario.getText();
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigoFuncionario() {
		return codigoFuncionario;
	}

	public void setCodigoFuncionario(String codigoFuncionario) {
		this.codigoFuncionario = codigoFuncionario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
