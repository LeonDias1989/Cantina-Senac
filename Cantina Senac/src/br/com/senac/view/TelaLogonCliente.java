package br.com.senac.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class TelaLogonCliente extends JFrame implements ActionListener {

	private JLabel labelClienteLogon;
	private JLabel labelMatricula;
	private JLabel labelSenha;

	private JTextField textFieldMatricula;
	private JPasswordField passwordField;

	private JButton buttonOk;
	private JButton buttonCancelar;

	public TelaLogonCliente() {

		iniciarComponentes();

		getContentPane().setBackground(Color.WHITE);
		setTitle("Logon Cliente");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 424, 300);
		getContentPane().setLayout(null);
		setResizable(false);
		setVisible(true);

	}

	public static void main(String[] args) {
		new TelaLogonCliente();
	}

	private void iniciarComponentes() {
		labelClienteLogon = new JLabel("Cliente Logon");
		labelClienteLogon.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelClienteLogon.setBounds(127, 11, 121, 27);
		getContentPane().add(labelClienteLogon);

		labelMatricula = new JLabel("Matr\u00EDcula");
		labelMatricula.setBounds(127, 48, 89, 14);
		getContentPane().add(labelMatricula);

		textFieldMatricula = new JTextField();
		textFieldMatricula.setBounds(127, 67, 156, 20);
		getContentPane().add(textFieldMatricula);
		textFieldMatricula.setColumns(10);

		labelSenha = new JLabel("Senha");
		labelSenha.setBounds(127, 98, 89, 14);
		getContentPane().add(labelSenha);

		passwordField = new JPasswordField();
		passwordField.setBounds(127, 114, 156, 20);
		getContentPane().add(passwordField);

		buttonOk = new JButton("OK");
		buttonOk.setBounds(127, 145, 62, 23);
		getContentPane().add(buttonOk);

		buttonCancelar = new JButton("Cancelar");
		buttonCancelar.setBounds(194, 145, 89, 23);
		getContentPane().add(buttonCancelar);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		new TelaLogonCliente();
		setVisible(true);

	}

}
