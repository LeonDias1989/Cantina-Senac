package br.com.senac.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import java.awt.Font;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

@SuppressWarnings("serial")
public class TelaPrincipal extends JFrame {

	private JPanel panelLog;
	private JComboBox<String> comboBoxEscolha;
	private JLabel labelCantinaSenac;
	private JLabel labelAcesseConta;
	private JButton btnCadastrarCliente;
	private JButton buttonCadastrarFuncionario;
	private JMenu menuArquivo;
	private JMenuBar menuBar;
	private JMenuItem menuItemSair;
	private JLabel labelSenac;

	public TelaPrincipal() {
		setTitle("Menu Principal");

		iniciarComponentes();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 626, 448);
		setResizable(false);
		setVisible(true);

	}

	private void iniciarComponentes() {

		panelLog = new JPanel();
		panelLog.setBackground(Color.WHITE);
		getContentPane().add(panelLog, BorderLayout.CENTER);
		panelLog.setLayout(null);

		comboBoxEscolha = new JComboBox<>();
		comboBoxEscolha.setModel(new DefaultComboBoxModel<>(new String[] { "",
				"Cliente", "Funcion\u00E1rio " }));
		comboBoxEscolha.setBounds(10, 168, 200, 30);
		panelLog.add(comboBoxEscolha);

		btnCadastrarCliente = new JButton("Cliente");
		btnCadastrarCliente.setBounds(10, 234, 129, 23);
		panelLog.add(btnCadastrarCliente);

		buttonCadastrarFuncionario = new JButton("Funcion\u00E1rio");
		buttonCadastrarFuncionario.setBounds(10, 268, 129, 23);
		panelLog.add(buttonCadastrarFuncionario);

		JLabel labelCadastro = new JLabel("Cadastre-se");
		labelCadastro.setBounds(10, 209, 86, 14);
		panelLog.add(labelCadastro);

		labelAcesseConta = new JLabel("Acesse \u00E0 conta");
		labelAcesseConta.setBounds(10, 143, 129, 14);
		panelLog.add(labelAcesseConta);

		labelCantinaSenac = new JLabel("Cantina Senac");
		labelCantinaSenac.setFont(new Font("Microsoft YaHei", Font.BOLD, 18));
		labelCantinaSenac.setBounds(10, 77, 151, 14);
		panelLog.add(labelCantinaSenac);
		
		labelSenac = new JLabel("");
		labelSenac.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/Images/login.empresa.png")));
		labelSenac.setBounds(278, 80, 390, 177);
		panelLog.add(labelSenac);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		menuArquivo = new JMenu("Arquivo");
		menuArquivo.setMnemonic('a');
		menuBar.add(menuArquivo);

		menuItemSair = new JMenuItem("Sair");
		menuItemSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,
				InputEvent.CTRL_MASK));
		menuArquivo.add(menuItemSair);

	}

	public static void main(String[] args) {
		new TelaPrincipal();
	}
}
