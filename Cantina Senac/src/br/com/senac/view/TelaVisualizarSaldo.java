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

@SuppressWarnings("serial")
public class TelaVisualizarSaldo extends JFrame {
	private JLabel labelVisualizarSaldo;
	private JLabel labelMatricula;
	private JButton buttonVisualizar;
	private JTextField textFieldMatricula;

	public TelaVisualizarSaldo() {
		setTitle("Visualizar Saldo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 224, 225);
		getContentPane().setLayout(null);

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
		buttonVisualizar.setBounds(10, 114, 84, 23);
		buttonVisualizar.addActionListener(new ButtonVisualizarSaldo());
		getContentPane().add(buttonVisualizar);

		JButton buttonCancelar = new JButton("Cancelar");
		buttonCancelar.setBounds(104, 114, 96, 23);
		getContentPane().add(buttonCancelar);
		buttonCancelar.addActionListener(new ButtonCancelarController());
		setVisible(true);

	}

	class ButtonVisualizarSaldo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			String matricula = textFieldMatricula.getText();

			ClienteDAODB clienteDAODB = new ClienteDAODB();

			JOptionPane.showMessageDialog(
					null,
					"Ol� " + clienteDAODB.buscarPorMatricula(matricula)
							+ "\nSeu saldo � de "
							+ clienteDAODB.getSaldoDataBase(matricula)
							+ " reais", "Saldo Atual", 2);

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
