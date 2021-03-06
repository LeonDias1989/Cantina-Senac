package br.com.senac.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

import br.com.senac.dao.ClienteDAODB;
import br.com.senac.model.Cliente;

import java.awt.Color;

import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class TelaVisualizarSaldo extends JFrame {

	private JLabel labelVisualizarSaldo;
	private JLabel labelMatricula;

	private JButton buttonVisualizar;
	private JButton buttonCancelar;

	private JTextField textFieldMatricula;
	private JLabel labelSenha;
	private JPasswordField passwordField;

	public TelaVisualizarSaldo() {

		iniciarComponentes();

		getContentPane().setBackground(Color.WHITE);
		setTitle("Visualizar Saldo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 224, 228);
		getContentPane().setLayout(null);

		labelSenha = new JLabel("Senha");
		labelSenha.setBounds(10, 96, 46, 14);
		getContentPane().add(labelSenha);

		passwordField = new JPasswordField();
		passwordField.setBounds(67, 93, 133, 20);
		getContentPane().add(passwordField);

		setVisible(true);// TODO trocar depois, apenas para teste
		setResizable(false);

	}

	private void iniciarComponentes() {

		labelVisualizarSaldo = new JLabel("Visualizar Saldo");
		labelVisualizarSaldo.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelVisualizarSaldo.setBounds(10, 11, 167, 14);
		getContentPane().add(labelVisualizarSaldo);

		labelMatricula = new JLabel("Matr\u00EDcula");
		labelMatricula.setBounds(10, 57, 64, 14);
		getContentPane().add(labelMatricula);

		textFieldMatricula = new JTextField();
		textFieldMatricula.setBounds(67, 54, 133, 20);
		getContentPane().add(textFieldMatricula);
		textFieldMatricula.setColumns(10);

		buttonVisualizar = new JButton("OK");
		buttonVisualizar.setBounds(10, 142, 84, 23);
		buttonVisualizar.addActionListener(new ButtonVisualizarSaldo());
		getContentPane().add(buttonVisualizar);

		buttonCancelar = new JButton("Cancelar");
		buttonCancelar.setBounds(104, 142, 96, 23);
		buttonCancelar.addActionListener(new ButtonCancelarController());
		getContentPane().add(buttonCancelar);

	}

	class ButtonVisualizarSaldo implements ActionListener {

		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent e) {

			String matricula = textFieldMatricula.getText();

			ClienteDAODB clienteDAODB = new ClienteDAODB();

			Cliente cliente = clienteDAODB.getCliente(matricula);

			if (cliente.getSenha().equals(passwordField.getText())) {

				JOptionPane.showMessageDialog(null, "Ol� " + cliente.getNome()
						+ "\n" + "Seu saldo � de " + cliente.getSaldo()
						+ " reais");
				dispose();
			}
			else {

				JOptionPane.showMessageDialog(null, "Senha Errada", "Erro",
						JOptionPane.ERROR_MESSAGE);
				dispose();
			}
		}
	}

	class ButtonCancelarController implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			dispose();

		}
	}

	public static void main(String[] args) {
		new TelaVisualizarSaldo();
	}
}
