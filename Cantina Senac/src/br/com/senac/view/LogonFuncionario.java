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
public class LogonFuncionario extends JFrame implements ActionListener {
	private JLabel labelFuncionrioLogin;
	private JLabel labelCodigoFuncionario;
	private JTextField textField1;
	private JLabel labelSenha;
	private JPasswordField passwordField2;
	private JButton buttonOK;
	private JButton buttonCancelar;

	public LogonFuncionario() {
		setTitle("Funcion\u00E1rio Logon");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 391, 300);
		getContentPane().setLayout(null);

		labelFuncionrioLogin = new JLabel("Funcion\u00E1rio Login");
		labelFuncionrioLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelFuncionrioLogin.setBounds(111, 34, 196, 28);
		getContentPane().add(labelFuncionrioLogin);

		labelCodigoFuncionario = new JLabel("C\u00F3digo Funcion\u00E1rio");
		labelCodigoFuncionario.setBounds(111, 73, 132, 14);
		getContentPane().add(labelCodigoFuncionario);

		textField1 = new JTextField();
		textField1.setBounds(111, 88, 145, 20);
		getContentPane().add(textField1);
		textField1.setColumns(10);

		labelSenha = new JLabel("Senha");
		labelSenha.setBounds(111, 119, 46, 14);
		getContentPane().add(labelSenha);

		passwordField2 = new JPasswordField();
		passwordField2.setBounds(111, 134, 145, 20);
		getContentPane().add(passwordField2);

		buttonOK = new JButton("OK");
		buttonOK.setBounds(111, 165, 52, 23);
		getContentPane().add(buttonOK);

		buttonCancelar = new JButton("Cancelar");
		buttonCancelar.setBounds(168, 165, 88, 23);
		getContentPane().add(buttonCancelar);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		new LogonFuncionario();

	}

}
