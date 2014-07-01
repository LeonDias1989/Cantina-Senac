package br.com.senac.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.senac.dao.ClienteDAODB;
import br.com.senac.dao.ItemVendaDAODB;
import br.com.senac.dao.ProdutoDAODB;
import br.com.senac.dao.VendaDAODB;
import br.com.senac.model.Cliente;
import br.com.senac.model.Produto;
import br.com.senac.model.TabelaProduto;
import br.com.senac.model.Venda;

import javax.swing.ImageIcon;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class TelaVendaProduto extends JFrame implements ActionListener {

	private TabelaProduto tabelaProduto;
	private JButton buttonAdd, buttonAddKart;
	private JPanel panelButtons;
	private JButton buttonSair;

	private Cliente cliente;
	private Venda venda;
	private JButton buttonFinalizarVenda;
	private double valorTotal;
	private JTextField valorTotalTextField;

	public TelaVendaProduto(Cliente cliente, Venda venda) {
		super("Venda de Produtos");

		this.cliente = cliente;
		this.venda = venda;
		valorTotalTextField = new JTextField("" + valorTotal);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		tabelaProduto = new TabelaProduto();

		getContentPane().add(tabelaProduto, BorderLayout.CENTER);

		panelButtons = new JPanel(new FlowLayout());

		buttonAdd = new JButton("");
		buttonAdd.setBackground(Color.WHITE);
		buttonAdd.setToolTipText("cadastrar novo produto");
		buttonAdd.setIcon(new ImageIcon(TelaVendaProduto.class
				.getResource("/Images/fruitIcon - C\u00F3pia.png")));
		buttonAdd.addActionListener(this);

		buttonAddKart = new JButton("");
		buttonAddKart.setBackground(Color.WHITE);
		buttonAddKart.setToolTipText("Adicionar ao carrinho");
		buttonAddKart.setIcon(new ImageIcon(TelaVendaProduto.class
				.getResource("/Images/addKartIcon.png")));
		buttonAddKart.addActionListener(this);

		panelButtons.add(buttonAdd);
		panelButtons.add(buttonAddKart);

		buttonFinalizarVenda = new JButton("");
		buttonFinalizarVenda.setToolTipText("Finalizar Venda");
		buttonFinalizarVenda.setBackground(Color.WHITE);
		buttonFinalizarVenda.setIcon(new ImageIcon(TelaVendaProduto.class
				.getResource("/Images/IconFinalizarVenda.png")));
		buttonFinalizarVenda.addActionListener(this);
		panelButtons.add(buttonFinalizarVenda);

		getContentPane().add(panelButtons, BorderLayout.SOUTH);

		buttonSair = new JButton("");
		buttonSair.setBackground(Color.WHITE);
		buttonSair.setToolTipText("sair da tela de vendas");
		buttonSair.setIcon(new ImageIcon(TelaVendaProduto.class
				.getResource("/Images/exitIcon.png")));
		buttonSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				estornar();
				dispose();
			}
		});
		panelButtons.add(buttonSair);
		panelButtons.add(valorTotalTextField);

		setResizable(true);
		setSize(1000, 680);
		setVisible(true);
	}

	private void estornar(){
		
		ItemVendaDAODB itemVenda = new ItemVendaDAODB();
		itemVenda.estornarItensDeVenda(venda.getCodigoVenda());

		VendaDAODB vendaDAO = new VendaDAODB();

		vendaDAO.estornarVenda(venda.getCodigoVenda());
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
				new TelaVendaProduto(cliente, venda);

			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null,
						"Voc� deve digitar o pre�o com valor inteiro", "ERRO",
						JOptionPane.ERROR_MESSAGE);
			}

		} else if (e.getSource() == buttonAddKart) {

			// Pega o c�digo do produto selecionado
			int codigoDoProduto = tabelaProduto.addAoCarrinho();

			// Cria o item de venda conex�o
			ItemVendaDAODB itemVendaDAO = new ItemVendaDAODB();

			// Cria um item de venda
			itemVendaDAO.cadastrarIdemVenda(venda.getCodigoVenda(),
					codigoDoProduto);

			// cria-se uma lista com as id�s dos produtos
			List<Integer> listaInteiros = new ArrayList<>();

			// Obtem=se estes valores e adiciona-se � lista
			listaInteiros = itemVendaDAO.getIdProdutoDoCarrinho(venda
					.getCodigoVenda());

			// Cria-se uma lista de produtos (carrinho)
			List<Produto> listaProdutos = new ArrayList<>();

			// Cria-se um item conex�o de produto
			ProdutoDAODB produtoDAODB = new ProdutoDAODB();

			// Adiciona o produto � lista
			for (Integer integer : listaInteiros) {

				listaProdutos.add(produtoDAODB.getProduto(integer));

			}

			// Obtem-se o valor total da venda
			valorTotal = 0;
			for (Produto produto : listaProdutos) {
				valorTotal += produto.getPreco();
			}

			JOptionPane.showMessageDialog(null,
					"Produto " + produtoDAODB.getProduto(codigoDoProduto)
							+ " adicionado ao carrinho");

			valorTotalTextField.setText("" + valorTotal);

		} else if (e.getSource() == buttonFinalizarVenda) {

			int opcao = JOptionPane.showConfirmDialog(null,
					"Deseja encerrar a venda ?");

			if (opcao == 0) {

				if (cliente.getSaldo() >= valorTotal) {

					ClienteDAODB clienteDataBase = new ClienteDAODB();

					clienteDataBase.debitarSaldo(valorTotal,
							cliente.getMatricula());
					JOptionPane.showMessageDialog(null,
							"Venda Realizada com sucesso");
					dispose();

				} else {
					ItemVendaDAODB itemVenda = new ItemVendaDAODB();
					itemVenda.estornarItensDeVenda(venda.getCodigoVenda());

					VendaDAODB vendaDAO = new VendaDAODB();

					vendaDAO.estornarVenda(venda.getCodigoVenda());
					JOptionPane
							.showMessageDialog(
									null,
									"Cliente sem saldo\n"
											+ "Consulte o saldo total para efetuar uma venda depois",
									"ERRO", JOptionPane.ERROR_MESSAGE);
					dispose();

				}

			}

		}
	}

}
