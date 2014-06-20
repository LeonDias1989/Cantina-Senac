package br.com.senac.model;

import javax.swing.JTextField;

public class Produto {

	private String codigo;
	private String nome;
	private String categoria;
	private double preco;

	public Produto(String codigo, String nome, String categoria, double preco) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.categoria = categoria;
		this.preco = preco;
	}

	public Produto(JTextField textFieldCodigoProduto,
			JTextField textFieldNomeProduto, JTextField textFieldCategoria,
			double preco) {
		this.codigo = textFieldCodigoProduto.getText();
		this.nome = textFieldNomeProduto.getText();
		this.categoria = textFieldCategoria.getText();
		this.preco = preco;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

}
