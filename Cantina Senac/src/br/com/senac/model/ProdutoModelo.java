package br.com.senac.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class ProdutoModelo extends AbstractTableModel {

	private String cabe�alho[];
	private List<Produto> produtos;

	public ProdutoModelo(String[] cabe�alho, List<Produto> produtos) {
		super();
		this.cabe�alho = cabe�alho;
		this.produtos = produtos;
	}

	// =============================

	public String[] getCabe�alho() {
		return cabe�alho;
	}

	public void setCabe�alho(String[] cabe�alho) {
		this.cabe�alho = cabe�alho;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	// =============================

	@Override
	public int getColumnCount() {
		return this.cabe�alho.length;
	}

	@Override
	public int getRowCount() {
		return this.produtos.size();
	}

	@Override
	public String getColumnName(int column) {
		return this.cabe�alho[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		if (columnIndex == 0)
			return produtos.get(rowIndex).getCodigo();

		else if (columnIndex == 1)
			return produtos.get(rowIndex).getNome();

		else if (columnIndex == 2)
			return produtos.get(rowIndex).getCategoria();

		else
			return produtos.get(rowIndex).getPreco();
	}

	// =============================

	public void addProduto(Produto produto) {

		produtos.add(produto);
	}

	public void removerProduto(int linha) {

		produtos.remove(linha);
	}

	public void getProduto(int linha) {

		produtos.get(linha);
	}

}
