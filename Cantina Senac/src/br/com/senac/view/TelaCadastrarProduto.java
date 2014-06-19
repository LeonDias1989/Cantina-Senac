package br.com.senac.view;

import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class TelaCadastrarProduto extends JFrame {
	private JTextField textFieldCodigoProduto;
	private JLabel labelCodigoProduto;
	private JLabel labelNomeProduto;
	private JTextField textFieldNomeProduto;
	private JLabel labelCategoriaProduto;
	private JTextField textFieldCategoria;
	private JLabel labelPrecoProduto;
	private JTextField textField;
	private JButton btnNewButton;
	private JButton btnCancelar;

	public TelaCadastrarProduto() {
		
		setTitle("Cadastrar Produtos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		getContentPane().setLayout(null);
		
		labelCodigoProduto = new JLabel("C\u00F3digo Produto");
		labelCodigoProduto.setBounds(10, 45, 91, 14);
		getContentPane().add(labelCodigoProduto);
		
		textFieldCodigoProduto = new JTextField();
		textFieldCodigoProduto.setBounds(111, 42, 124, 20);
		getContentPane().add(textFieldCodigoProduto);
		textFieldCodigoProduto.setColumns(10);
		
		labelNomeProduto = new JLabel("Nome ");
		labelNomeProduto.setBounds(10, 70, 46, 14);
		getContentPane().add(labelNomeProduto);
		
		JLabel lblNewLabel = new JLabel("Cadastrar Produtos");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 11, 153, 14);
		getContentPane().add(lblNewLabel);
		
		textFieldNomeProduto = new JTextField();
		textFieldNomeProduto.setBounds(111, 67, 124, 20);
		getContentPane().add(textFieldNomeProduto);
		textFieldNomeProduto.setColumns(10);
		
		labelCategoriaProduto = new JLabel("Categoria");
		labelCategoriaProduto.setBounds(10, 95, 69, 14);
		getContentPane().add(labelCategoriaProduto);
		
		textFieldCategoria = new JTextField();
		textFieldCategoria.setBounds(111, 92, 124, 20);
		getContentPane().add(textFieldCategoria);
		textFieldCategoria.setColumns(10);
		
		labelPrecoProduto = new JLabel("Pre\u00E7o R$");
		labelPrecoProduto.setBounds(10, 120, 69, 14);
		getContentPane().add(labelPrecoProduto);
		
		textField = new JTextField();
		textField.setBounds(111, 117, 124, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("OK");
		btnNewButton.setBounds(10, 157, 69, 23);
		getContentPane().add(btnNewButton);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(111, 157, 124, 23);
		getContentPane().add(btnCancelar);
		
		
		
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new TelaCadastrarProduto();
		
	}
}