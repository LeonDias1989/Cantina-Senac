package br.com.senac.model;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.com.senac.dao.ProdutoDAODB;

@SuppressWarnings("serial")
public class TabelaProduto extends JPanel {

	private JTable tabela;
	private String[] colunas = { "Codigo", "Nome", "Tipo", "Pre�o" };

	private List<Produto> linhas;
	private ProdutoDAODB produtoDAODB = new ProdutoDAODB();
	private ProdutoModelo produtoModelo;

	public TabelaProduto() {

		linhas = produtoDAODB.getAllProdutos();

		produtoModelo = new ProdutoModelo(colunas, linhas);

		tabela = new JTable(produtoModelo);

		tabela.setPreferredScrollableViewportSize(new Dimension(800, 1000));
		tabela.setFillsViewportHeight(true);

		JScrollPane scrollPane = new JScrollPane(tabela);

		add(scrollPane);
	}

	public JTable getTabela() {
		return tabela;
	}

	public void addProduto(Produto produto) {

		Produto novoProduto = new Produto();

		novoProduto.setNome(produto.getNome());
		novoProduto.setCategoria(produto.getCategoria());
		novoProduto.setPreco(produto.getPreco());

		ProdutoModelo produtoModelo = (ProdutoModelo) getTabela().getModel();
		produtoModelo.addProduto(produto);
		produtoDAODB.cadastrar(novoProduto);
		JOptionPane.showMessageDialog(null,
				"Produto cadastrado com sucesso ao banco");
		getTabela().updateUI();

	}

	private void removerProduto(int linha) {

		ProdutoModelo produtoModelo = (ProdutoModelo) getTabela().getModel();

		produtoModelo.removerProduto(linha);
		getTabela().updateUI();

	}

	/** Remove o produto somente da tabelas de demonstra��o */
	public void removerProduto() {

		int linha = getTabela().getSelectedRow();

		if (linha >= 0) {

			removerProduto(linha);
		}

	}

	public int addAoCarrinho() {

		int rowIndex = getTabela().getSelectedRow();

		Object object = produtoModelo.getValueAt(rowIndex, 0);
		int codigoProduto = (Integer) object;
		return codigoProduto;

	}

	public void showGUI() {

		JFrame frame = new JFrame();

		frame.getContentPane().add(this.getTabela());
		frame.setVisible(true);
		frame.pack();

	}

	public static void main(String[] args) {

		TabelaProduto tabelaProduto = new TabelaProduto();

		tabelaProduto.showGUI();

	}

}
