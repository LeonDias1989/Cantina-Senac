package br.com.senac.view;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.SystemColor;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class TelaPrincipalCliente extends JFrame {
	private JMenuBar barraDeMenus;
	private JMenu menuArquivo;
	private JMenuItem menuItemSair;
	private JPanel painelDadosCliente;
	private JLabel labelBemVindo;
	private JLabel labelMatricula;
	private JLabel labelEmail;
	private JTextField textFieldNomeCliente;
	private JTextField textFieldMatricula;
	private JTextField textFieldEmail;
	private JLabel lblCreditarSaldo;
	private JButton buttonVisualizarCompras;
	private JLabel lblVisualizarCompras;
	private JButton buttonSaldoTotal;
	private JLabel lblSaldo;
	private JTextField textFieldSaldo;
	private JButton buttonCreditarSaldo;
	private JButton buttonSair;

	public JTextField getTextFieldNomeCliente() {
		return textFieldNomeCliente;
	}

	public JTextField getTextFieldMatricula() {
		return textFieldMatricula;
	}

	public JTextField getTextFieldEmail() {
		return textFieldEmail;
	}

	public JTextField getTextFielSaldo() {
		return textFieldSaldo;
	}

	public TelaPrincipalCliente() {

		iniciarMenuBar();
		iniciarPanelDadosCliente();
		iniciarPanelCompras();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(1366, 750);
		setVisible(true);
		setResizable(false);

	}

	private void iniciarPanelCompras() {

		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);

		JPanel painelOperacoesCliente = new JPanel();
		painelOperacoesCliente.setBackground(SystemColor.inactiveCaption);
		painelOperacoesCliente.setBounds(10, 231, 268, 467);
		getContentPane().add(painelOperacoesCliente);
		painelOperacoesCliente.setLayout(null);

		buttonCreditarSaldo = new JButton("");
		buttonCreditarSaldo.setBackground(SystemColor.inactiveCaption);
		buttonCreditarSaldo.setIcon(new ImageIcon(TelaPrincipalCliente.class
				.getResource("/Images/ValueIcon.png")));
		buttonCreditarSaldo.setBounds(10, 68, 104, 78);
		painelOperacoesCliente.add(buttonCreditarSaldo);

		lblCreditarSaldo = new JLabel("Creditar Saldo");
		lblCreditarSaldo.setBounds(10, 41, 104, 14);
		painelOperacoesCliente.add(lblCreditarSaldo);

		buttonVisualizarCompras = new JButton("");
		buttonVisualizarCompras.setIcon(new ImageIcon(TelaPrincipalCliente.class
				.getResource("/Images/compras.jpg")));
		buttonVisualizarCompras.setBackground(SystemColor.inactiveCaption);
		buttonVisualizarCompras.setBounds(10, 197, 104, 85);
		painelOperacoesCliente.add(buttonVisualizarCompras);

		lblVisualizarCompras = new JLabel("Visualizar Compras");
		lblVisualizarCompras.setBounds(10, 172, 157, 14);
		painelOperacoesCliente.add(lblVisualizarCompras);

		buttonSaldoTotal = new JButton("");
		buttonSaldoTotal.setIcon(new ImageIcon(TelaPrincipalCliente.class
				.getResource("/Images/TotalValueIcon.png")));
		buttonSaldoTotal.setBounds(10, 328, 104, 98);
		painelOperacoesCliente.add(buttonSaldoTotal);

		JLabel lblVisualizarSaldo = new JLabel("Visualizar Saldo");
		lblVisualizarSaldo.setBounds(10, 303, 104, 14);
		painelOperacoesCliente.add(lblVisualizarSaldo);

		buttonSair = new JButton("");
		buttonSair.setBackground(Color.WHITE);
		buttonSair.setIcon(new ImageIcon(TelaPrincipalCliente.class
				.getResource("/Images/Log Out.png")));
		buttonSair.setBounds(1279, 594, 71, 59);
		buttonSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		getContentPane().add(buttonSair);

	}

	private void iniciarMenuBar() {

		barraDeMenus = new JMenuBar();
		setJMenuBar(barraDeMenus);

		menuArquivo = new JMenu("Arquivo");
		menuArquivo.setMnemonic('a');
		barraDeMenus.add(menuArquivo);

		menuItemSair = new JMenuItem("Sair");
		menuItemSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,
				InputEvent.CTRL_MASK));
		menuArquivo.add(menuItemSair);

	}

	private void iniciarPanelDadosCliente() {
		painelDadosCliente = new JPanel();
		painelDadosCliente.setBackground(SystemColor.inactiveCaption);
		painelDadosCliente.setBounds(10, 11, 268, 209);
		getContentPane().add(painelDadosCliente);
		painelDadosCliente.setLayout(null);

		labelBemVindo = new JLabel("Bem vindo:");
		labelBemVindo.setBounds(10, 11, 80, 14);
		painelDadosCliente.add(labelBemVindo);

		labelMatricula = new JLabel("Matr\u00EDcula:");
		labelMatricula.setBounds(10, 86, 80, 14);
		painelDadosCliente.add(labelMatricula);

		labelEmail = new JLabel("E-mail");
		labelEmail.setBounds(10, 111, 46, 14);
		painelDadosCliente.add(labelEmail);

		textFieldNomeCliente = new JTextField();
		textFieldNomeCliente.setEditable(false);
		textFieldNomeCliente.setBounds(100, 8, 158, 20);
		painelDadosCliente.add(textFieldNomeCliente);
		textFieldNomeCliente.setColumns(10);

		textFieldMatricula = new JTextField();
		textFieldMatricula.setEditable(false);
		textFieldMatricula.setBounds(100, 83, 158, 20);
		painelDadosCliente.add(textFieldMatricula);
		textFieldMatricula.setColumns(10);

		textFieldEmail = new JTextField();
		textFieldEmail.setEditable(false);
		textFieldEmail.setBounds(100, 108, 158, 20);
		painelDadosCliente.add(textFieldEmail);
		textFieldEmail.setColumns(10);

		lblSaldo = new JLabel("Saldo");
		lblSaldo.setBounds(10, 136, 46, 14);
		painelDadosCliente.add(lblSaldo);

		textFieldSaldo = new JTextField();
		textFieldSaldo.setEditable(false);
		textFieldSaldo.setBounds(100, 133, 158, 20);
		painelDadosCliente.add(textFieldSaldo);
		textFieldSaldo.setColumns(10);

	}

	public static void main(String[] args) {
		new TelaPrincipalCliente();

	}
}
