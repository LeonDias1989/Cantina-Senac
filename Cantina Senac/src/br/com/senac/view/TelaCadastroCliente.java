package br.com.senac.view;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import br.com.senac.dao.ClienteDAODB;
import br.com.senac.model.Cliente;

import java.awt.Color;

@SuppressWarnings("serial")
public class TelaCadastroCliente extends JFrame implements ActionListener {

	private JLabel labelCadastroCliente;
	private JLabel labelNome;
	private JLabel labelMatricula;
	private JLabel labelEmail;
	private JLabel labelDigiteASenha;
	private JLabel labelConfirmeASenha;

	private JTextField textFieldNome;
	private JTextField textFieldMatricula;
	private JTextField textFieldEmail;

	private JPasswordField passwordField1;
	private JPasswordField passwordField2;

	private JButton buttonOk;
	private JButton buttonCancelar;

	public TelaCadastroCliente() {
		super("Cadastro Cliente");

		iniciarComponentes();
		getContentPane().setBackground(Color.WHITE);
		setSize(377, 450);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		setResizable(false);

	}

	private void iniciarComponentes() {

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

		labelDigiteASenha = new JLabel("Digite a senha (Max. 8 D\u00EDgitos)");
		labelDigiteASenha.setBounds(93, 213, 202, 14);
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

		buttonOk.addActionListener(new ButtonOkController());
		getContentPane().add(buttonOk);

		buttonCancelar = new JButton("Cancelar");
		buttonCancelar.setToolTipText("Cancelar Cadastro");
		buttonCancelar.setBounds(160, 325, 89, 23);
		buttonCancelar.addActionListener(new ButtonCancelarController());
		getContentPane().add(buttonCancelar);

	}

	class ButtonOkController implements ActionListener {

		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e) {

			if (passwordField1.getText().equals(passwordField2.getText())
					&& (!passwordField1.getText().equals(""))) {

				String senha = new String(passwordField1.getPassword());

				Cliente cliente = new Cliente(textFieldMatricula,
						textFieldNome, textFieldEmail, senha);

				ClienteDAODB clienteDAODB = new ClienteDAODB();

				int rows = clienteDAODB.cadastrar(cliente);

				if (rows > 0) {
					JOptionPane.showMessageDialog(null,
							"Cadastro Realizado com Sucesso", "Cadastrado(a)",
							2);
				}

				textFieldMatricula.setText("");
				textFieldNome.setText("");
				textFieldEmail.setText("");
				passwordField1.setText("");
				passwordField2.setText("");

			} else
				JOptionPane.showMessageDialog(null, "ERRO Senhas Diferentes",
						"ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}

	class ButtonCancelarController implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			dispose();

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new TelaCadastroCliente();
		setVisible(true);
	}

}
