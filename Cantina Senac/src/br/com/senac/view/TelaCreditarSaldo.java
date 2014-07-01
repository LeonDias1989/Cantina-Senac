package br.com.senac.view;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import br.com.senac.dao.ClienteDAODB;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class TelaCreditarSaldo extends JFrame {

	private JLabel labelMatricula;
	private JLabel labelCreditarSaldo;
	private JLabel labelValor;
	private JTextField textFieldMatricula;
	private JTextField textFieldValor;
	private JButton buttonCreditar;
	private JButton buttonCancelar;

	public TelaCreditarSaldo() {
		getContentPane().setBackground(Color.WHITE);
		setTitle("Creditar Saldo");

		iniciarComponentes();

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 234, 313);
		getContentPane().setLayout(null);

		setVisible(true);
		setResizable(false);

	}

	private void iniciarComponentes() {
		labelCreditarSaldo = new JLabel("Creditar Saldo");
		labelCreditarSaldo.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelCreditarSaldo.setBounds(10, 11, 239, 14);
		getContentPane().add(labelCreditarSaldo);

		labelMatricula = new JLabel("Matr\u00EDcula");
		labelMatricula.setBounds(10, 46, 57, 14);
		getContentPane().add(labelMatricula);

		textFieldMatricula = new JTextField();
		textFieldMatricula.setBounds(77, 43, 118, 20);
		getContentPane().add(textFieldMatricula);
		textFieldMatricula.setColumns(10);

		labelValor = new JLabel("Valor R$");
		labelValor.setBounds(10, 71, 57, 14);
		getContentPane().add(labelValor);

		textFieldValor = new JTextField();
		// textFieldValor.setText("XXXX,XX");
		textFieldValor.setBounds(77, 68, 118, 20);
		getContentPane().add(textFieldValor);
		textFieldValor.setColumns(10);

		buttonCreditar = new JButton("Creditar");
		buttonCreditar.setBounds(10, 158, 89, 23);

		buttonCreditar.addActionListener(new ButtonCreditarController());

		getContentPane().add(buttonCreditar);

		buttonCancelar = new JButton("Cancelar");
		buttonCancelar.setBounds(106, 158, 89, 23);
		buttonCancelar.addActionListener(new ButtonCancelarController());
		getContentPane().add(buttonCancelar);

	}

	class ButtonCreditarController implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			String matricula = textFieldMatricula.getText();
			double saldo = Double.parseDouble(textFieldValor.getText());

			// TODO efetuar consultas no banco para validar se foi creditado o
			// saldo ao funcionário

			ClienteDAODB clienteDAODB = new ClienteDAODB();

			clienteDAODB.creditarSaldo(saldo, matricula);

			JOptionPane.showMessageDialog(null, "Creditado com Sucesso",
					"Saldo de " + saldo + " reais creditado com sucesso", 2);

			textFieldMatricula.setText("");
			// textFieldValor.setText("XXX, XX");
			textFieldValor.setText("");

		}
	}

	class ButtonCancelarController implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			dispose();

		}
	}

	public static void main(String[] args) {
		new TelaCreditarSaldo();
	}
}
