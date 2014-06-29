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

@SuppressWarnings("serial")
public class TelaVendaProduto extends JFrame implements ActionListener {

	private TabelaProduto tabelaProduto;
	private JButton buttonAdd, buttonRemove, buttonAddKart;
	private JPanel panelButtons;

	public TelaVendaProduto() {
		super("Janela de Demonstra��o");

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		tabelaProduto = new TabelaProduto();

		getContentPane().add(tabelaProduto, BorderLayout.CENTER);

		panelButtons = new JPanel(new FlowLayout());

		buttonAdd = new JButton("Cadastrar Produto");
		buttonAdd.addActionListener(this);

		buttonRemove = new JButton("Remover");
		buttonRemove.addActionListener(this);
		buttonRemove.setEnabled(false);

		buttonAddKart = new JButton("Add Kart");
		buttonAddKart.addActionListener(this);

		panelButtons.add(buttonAdd);
		panelButtons.add(buttonAddKart);
		panelButtons.add(buttonRemove);

		getContentPane().add(panelButtons, BorderLayout.SOUTH);

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
				
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null,
						"Voc� deve digitar o pre�o com valor inteiro", "ERRO",
						JOptionPane.ERROR_MESSAGE);
			}
			

		} else if (e.getSource() == buttonRemove) {

			tabelaProduto.removerProduto();
		} else if (e.getSource() == buttonAddKart) {

		}
	}

	public static void main(String[] args) {
		new TelaVendaProduto();
	}

}