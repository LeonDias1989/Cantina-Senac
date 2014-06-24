package br.com.senac.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.BevelBorder;

@SuppressWarnings("serial")
public class TelaLogon extends JFrame {

	private JButton buttonFuncionario;
	private JButton buttonCliente;
	private JButton buttonCriarNovoFuncionario;
	private JLabel labelSenac;
	private JLabel labelNaoPossuiF;
	private JLabel labelNaoPossuiC;
	private JPanel panelSenha;
	private JMenu menuArquivo;
	private JMenuBar menuBar;
	private JMenuItem menuItemSair;

	public TelaLogon() {

		iniciarComponentes();

		getContentPane().setBackground(Color.WHITE);
		setTitle("Logon");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1024, 700);
		getContentPane().setLayout(null);
		setResizable(false);

	}

	private void iniciarComponentes() {

		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1008, 19);

		menuArquivo = new JMenu("Arquivo");
		menuArquivo.setMnemonic('a');
		menuBar.add(menuArquivo);

		menuItemSair = new JMenuItem("Sair");
		menuItemSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,
				InputEvent.CTRL_MASK));
		menuArquivo.add(menuItemSair);

		menuItemSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);

			}
		});

		labelSenac = new JLabel("");
		labelSenac.setToolTipText("Cantina Senac");
		labelSenac.setIcon(new ImageIcon(TelaLogon.class
				.getResource("/Images/login.empresa.png")));
		labelSenac.setBounds(0, 95, 422, 225);

		panelSenha = new JPanel();
		panelSenha.setBackground(Color.WHITE);
		panelSenha.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		panelSenha.setBounds(507, 72, 436, 578);

		panelSenha.setLayout(null);

		buttonFuncionario = new JButton("Sou Funcion\u00E1rio");
		buttonFuncionario.setToolTipText("Logar como funcion\u00E1rio");
		buttonFuncionario.setFont(new Font("Calibri Light", Font.BOLD, 15));
		buttonFuncionario.setBounds(81, 175, 156, 42);
		buttonFuncionario.addActionListener(new TelaLogonFuncionario());

		panelSenha.add(buttonFuncionario);

		buttonCliente = new JButton("Sou Cliente");
		buttonCliente.setToolTipText("Logar como cliente");
		buttonCliente.setFont(new Font("Calibri Light", Font.BOLD, 15));
		buttonCliente.setBounds(267, 175, 155, 42);
		buttonCliente.addActionListener(new TelaLogonCliente());

		panelSenha.add(buttonCliente);

		labelNaoPossuiF = new JLabel("N\u00E3o possui cadastro?");
		labelNaoPossuiF.setBounds(81, 228, 145, 14);
		panelSenha.add(labelNaoPossuiF);

		buttonCriarNovoFuncionario = new JButton("Crie uma nova conta");
		buttonCriarNovoFuncionario
				.setToolTipText("Cadastrar uma nova conta de funcion\u00E1rio");
		buttonCriarNovoFuncionario.setBounds(81, 243, 156, 23);
		buttonCriarNovoFuncionario
				.addActionListener(new TelaCadastrarFuncionario());

		panelSenha.add(buttonCriarNovoFuncionario);

		JButton buttonCriarNovoCliente = new JButton("Crie uma nova conta");
		buttonCriarNovoCliente
				.setToolTipText("Cadastrar uma nova conta de cliente");
		buttonCriarNovoCliente.setBounds(267, 243, 155, 23);
		buttonCriarNovoCliente.addActionListener(new TelaCadastroCliente());
		panelSenha.add(buttonCriarNovoCliente);

		labelNaoPossuiC = new JLabel("N\u00E3o possui cadastro?");
		labelNaoPossuiC.setBounds(267, 228, 136, 14);
		panelSenha.add(labelNaoPossuiC);
		setVisible(true);

		getContentPane().add(menuBar);
		getContentPane().add(labelSenac);
		getContentPane().add(panelSenha);
	}

	// TODO CRIAR CLASSE PRINCIPAL PARA EXECUTAR A APLICA��O
	public static void main(String[] args) {
		new TelaLogon();

	}
}
