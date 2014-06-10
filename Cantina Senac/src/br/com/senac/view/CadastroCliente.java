package br.com.senac.view;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class CadastroCliente extends JFrame implements ActionListener {
	private JLabel labelCadastroCliente;
	private JLabel labelNome;
	private JTextField textFieldNome;
	private JLabel labelMatricula;
	private JTextField textFieldMatricula;
	private JLabel labelEmail;
	private JTextField textFieldEmail;
	private JPasswordField passwordField1;
	private JLabel labelDigiteASenha;
	private JLabel labelConfirmeASenha;
	private JPasswordField passwordField2;
	private JButton buttonOk;
	private JButton buttonCancelar;

	public CadastroCliente() {
		super("Cadastro Cliente");

		setSize(395, 450);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		labelCadastroCliente = new JLabel("Cadastro Cliente");
		labelCadastroCliente.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelCadastroCliente.setBounds(93, 29, 156, 14);
		getContentPane().add(labelCadastroCliente);

		labelNome = new JLabel("Nome");
		labelNome.setBounds(93, 54, 46, 14);
		getContentPane().add(labelNome);

		textFieldNome = new JTextField();
		textFieldNome.setBounds(93, 71, 156, 20);
		getContentPane().add(textFieldNome);
		textFieldNome.setColumns(10);

		labelMatricula = new JLabel("Matr\u00EDcula");
		labelMatricula.setBounds(93, 102, 95, 14);
		getContentPane().add(labelMatricula);

		textFieldMatricula = new JTextField();
		textFieldMatricula.setBounds(93, 116, 156, 20);
		getContentPane().add(textFieldMatricula);
		textFieldMatricula.setColumns(10);

		labelEmail = new JLabel("E-mail");
		labelEmail.setBounds(93, 147, 46, 14);
		getContentPane().add(labelEmail);

		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(93, 165, 156, 20);
		getContentPane().add(textFieldEmail);
		textFieldEmail.setColumns(10);

		labelDigiteASenha = new JLabel("Digite a senha");
		labelDigiteASenha.setBounds(93, 213, 95, 14);
		getContentPane().add(labelDigiteASenha);

		passwordField1 = new JPasswordField();
		passwordField1.setBounds(93, 238, 156, 20);
		getContentPane().add(passwordField1);

		labelConfirmeASenha = new JLabel("Confirme a senha: ");
		labelConfirmeASenha.setBounds(93, 269, 156, 14);
		getContentPane().add(labelConfirmeASenha);

		passwordField2 = new JPasswordField();
		passwordField2.setBounds(93, 294, 156, 20);
		getContentPane().add(passwordField2);

		buttonOk = new JButton("OK");
		buttonOk.setToolTipText("Confirmar cadastro?");
		buttonOk.setBounds(93, 325, 55, 23);
		getContentPane().add(buttonOk);

		buttonCancelar = new JButton("Cancelar");
		buttonCancelar.setToolTipText("Cancelar Cadastro");
		buttonCancelar.setBounds(160, 325, 89, 23);
		getContentPane().add(buttonCancelar);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		new CadastroCliente();

	}
}
