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
public class CadastroFuncionario extends JFrame implements ActionListener{
	
	private JLabel labelCadastrarFuncionario;
	private JTextField textField;
	private JLabel labelNome;
	private JTextField textField_1;
	private JLabel labelDigiteASenha;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JButton buttonCadastrar;
	private JButton buttonCancelar;

	public CadastroFuncionario() {
		super("Cadastrar Funcionário");

		setSize(395, 450);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		labelCadastrarFuncionario = new JLabel("Cadastrar Funcion\u00E1rio");
		labelCadastrarFuncionario.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelCadastrarFuncionario.setBounds(104, 35, 202, 14);
		getContentPane().add(labelCadastrarFuncionario);

		JLabel labelCodigoDoFuncionrio = new JLabel(
				"Codigo do Funcion\u00E1rio");
		labelCodigoDoFuncionrio.setBounds(104, 105, 149, 14);
		getContentPane().add(labelCodigoDoFuncionrio);

		textField = new JTextField();
		textField.setBounds(104, 121, 167, 20);
		getContentPane().add(textField);
		textField.setColumns(10);

		labelNome = new JLabel("Nome");
		labelNome.setBounds(104, 60, 46, 14);
		getContentPane().add(labelNome);

		textField_1 = new JTextField();
		textField_1.setBounds(104, 74, 167, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);

		labelDigiteASenha = new JLabel("Digite a senha");
		labelDigiteASenha.setBounds(104, 177, 167, 14);
		getContentPane().add(labelDigiteASenha);

		passwordField = new JPasswordField();
		passwordField.setBounds(104, 190, 167, 20);
		getContentPane().add(passwordField);

		JLabel labelConfirmeSuaSenha = new JLabel("Confirme sua senha:");
		labelConfirmeSuaSenha.setBounds(104, 221, 167, 14);
		getContentPane().add(labelConfirmeSuaSenha);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(104, 234, 167, 20);
		getContentPane().add(passwordField_1);

		buttonCadastrar = new JButton("OK");
		buttonCadastrar.setToolTipText("Cadastrar funcion\u00E1rio?");
		buttonCadastrar.setBounds(104, 265, 67, 23);
		getContentPane().add(buttonCadastrar);

		buttonCancelar = new JButton("Cancelar");
		buttonCancelar.setToolTipText("Cancelar o cadastro?");
		buttonCancelar.setBounds(182, 265, 89, 23);
		getContentPane().add(buttonCancelar);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		new CadastroFuncionario();
		//TODO insert on data base
	}

}
