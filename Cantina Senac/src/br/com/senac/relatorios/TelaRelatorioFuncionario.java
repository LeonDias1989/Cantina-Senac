package br.com.senac.relatorios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class TelaRelatorioFuncionario extends JFrame {
	

	private JPanel contentPane;
	private String textoRelatorio;
	private JTextArea textArea;
	private JButton btnSair;

	public String getTextoRelatorio() {
		return textoRelatorio;
	}

	public TelaRelatorioFuncionario(String textoRelatorio) {

		this.textoRelatorio = textoRelatorio;

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 687, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(70, 33, 556, 354);
		contentPane.add(scrollPane);

		textArea = new JTextArea(textoRelatorio);
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);

		btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				dispose();
			}
		});
		btnSair.setBounds(70, 398, 89, 23);
		contentPane.add(btnSair);
		
		JLabel lblRelatrioFuncionrio = new JLabel("Relat\u00F3rio Funcion\u00E1rio");
		lblRelatrioFuncionrio.setBounds(70, 11, 173, 14);
		contentPane.add(lblRelatrioFuncionrio);
		setVisible(true);
		setResizable(false);
	}

	public static void main(String[] args) {
		new TelaRelatorioCliente(new String());
	}
}
