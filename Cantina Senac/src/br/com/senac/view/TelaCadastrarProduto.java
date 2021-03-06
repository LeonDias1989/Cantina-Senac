package br.com.senac.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import br.com.senac.dao.ProdutoDAODB;
import br.com.senac.model.Produto;
import java.awt.Color;

@SuppressWarnings("serial")
public class TelaCadastrarProduto extends JFrame {

	private JLabel labelNomeProduto;
	private JLabel labelCategoriaProduto;
	private JLabel labelPrecoProduto;
	private JLabel labelCadastrarProduto;

	private JTextField textFieldNomeProduto;
	private JTextField textFieldCategoria;
	private JTextField textFieldPreco;

	private JButton buttonOk;
	private JButton buttonCancelar;

	public TelaCadastrarProduto() {
		getContentPane().setBackground(Color.WHITE);

		iniciarComponentes();

		setTitle("Cadastrar Produtos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 286, 222);
		getContentPane().setLayout(null);

		setResizable(false);
		setVisible(true);

	}

	private void iniciarComponentes() {

		labelNomeProduto = new JLabel("Nome ");
		labelNomeProduto.setBounds(33, 42, 46, 14);
		getContentPane().add(labelNomeProduto);

		labelCadastrarProduto = new JLabel("Cadastrar Produtos");
		labelCadastrarProduto.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelCadastrarProduto.setBounds(64, 11, 153, 14);
		getContentPane().add(labelCadastrarProduto);

		textFieldNomeProduto = new JTextField();
		textFieldNomeProduto.setBounds(109, 39, 124, 20);
		getContentPane().add(textFieldNomeProduto);
		textFieldNomeProduto.setColumns(10);

		labelCategoriaProduto = new JLabel("Categoria");
		labelCategoriaProduto.setBounds(33, 73, 69, 14);
		getContentPane().add(labelCategoriaProduto);

		textFieldCategoria = new JTextField();
		textFieldCategoria.setBounds(109, 70, 124, 20);
		getContentPane().add(textFieldCategoria);
		textFieldCategoria.setColumns(10);

		labelPrecoProduto = new JLabel("Pre\u00E7o R$");
		labelPrecoProduto.setBounds(33, 106, 69, 14);
		getContentPane().add(labelPrecoProduto);

		textFieldPreco = new JTextField();
		textFieldPreco.setBounds(109, 103, 124, 20);
		getContentPane().add(textFieldPreco);
		textFieldPreco.setColumns(10);

		buttonOk = new JButton("OK");
		buttonOk.setBounds(33, 145, 69, 23);
		buttonOk.addActionListener(new ButtonOkController());
		getContentPane().add(buttonOk);

		buttonCancelar = new JButton("Cancelar");
		buttonCancelar.setBounds(139, 145, 94, 23);
		buttonCancelar.addActionListener(new ButtonCancelController());
		getContentPane().add(buttonCancelar);

	}

	class ButtonOkController implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			double preco = Double.parseDouble(textFieldPreco.getText());

			Produto produto = new Produto(textFieldNomeProduto.getText(),
					textFieldCategoria.getText(), preco);

			ProdutoDAODB produtoDAODB = new ProdutoDAODB();

			int rows = produtoDAODB.cadastrar(produto);

			if (rows > 0) {
				JOptionPane.showMessageDialog(null,
						"Cadastro Realizado com Sucesso", "Cadastrado(a)", 2);
			} else {
				JOptionPane.showMessageDialog(null, "Produto n�o cadastrado",
						"ERRO", JOptionPane.ERROR_MESSAGE);
			}

			textFieldNomeProduto.setText("");
			textFieldCategoria.setText("");
			textFieldPreco.setText("");

		}
	}

	class ButtonCancelController implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			dispose();

		}
	}

	public static void main(String[] args) {
		new TelaCadastrarProduto();

	}
}
