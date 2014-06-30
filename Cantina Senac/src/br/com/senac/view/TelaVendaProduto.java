package br.com.senac.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import br.com.senac.model.Produto;
import br.com.senac.model.TabelaProduto;
import javax.swing.ImageIcon;
import java.awt.Color;

@SuppressWarnings("serial")
public class TelaVendaProduto extends JFrame implements ActionListener {

	private TabelaProduto tabelaProduto;
	private JButton buttonAdd, buttonRemove, buttonAddKart;
	private JPanel panelButtons;
	private JButton buttonSair;

	public TelaVendaProduto() {
		super("Venda de Produtos");

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		tabelaProduto = new TabelaProduto();

		getContentPane().add(tabelaProduto, BorderLayout.CENTER);

		panelButtons = new JPanel(new FlowLayout());

		buttonAdd = new JButton("");
		buttonAdd.setBackground(Color.WHITE);
		buttonAdd.setToolTipText("cadastrar novo produto");
		buttonAdd.setIcon(new ImageIcon(TelaVendaProduto.class.getResource("/Images/fruitIcon - C\u00F3pia.png")));
		buttonAdd.addActionListener(this);

		buttonRemove = new JButton("Remover");
		buttonRemove.addActionListener(this);
		buttonRemove.setEnabled(false);

		buttonAddKart = new JButton("");
		buttonAddKart.setBackground(Color.WHITE);
		buttonAddKart.setToolTipText("Adicionar ao carrinho");
		buttonAddKart.setIcon(new ImageIcon(TelaVendaProduto.class.getResource("/Images/addKartIcon.png")));
		buttonAddKart.addActionListener(this);

		panelButtons.add(buttonAdd);
		panelButtons.add(buttonAddKart);
		panelButtons.add(buttonRemove);

		getContentPane().add(panelButtons, BorderLayout.SOUTH);

		buttonSair = new JButton("");
		buttonSair.setBackground(Color.WHITE);
		buttonSair.setToolTipText("sair da tela de vendas");
		buttonSair.setIcon(new ImageIcon(TelaVendaProduto.class.getResource("/Images/exitIcon.png")));
		buttonSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		panelButtons.add(buttonSair);

		setResizable(true);
		setSize(1000, 680);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonAdd) {

			double preco = 0;

			String nome = JOptionPane.showInputDialog("Nome: ");
			String categoria = JOptionPane.showInputDialog("Categoria:");

			try {
				preco = Double.parseDouble(JOptionPane
						.showInputDialog("Pre�o: "));
				tabelaProduto.addProduto(new Produto(nome, categoria, preco));
				dispose();
				new TelaVendaProduto();

			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null,
						"Voc� deve digitar o pre�o com valor inteiro", "ERRO",
						JOptionPane.ERROR_MESSAGE);
			}

		} else if (e.getSource() == buttonRemove) {

			tabelaProduto.removerProduto();
		} else if (e.getSource() == buttonAddKart) {

			tabelaProduto.addAoCarrinho();
		}
	}

	public static void main(String[] args) {
		new TelaVendaProduto();
	}

}
